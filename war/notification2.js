alert("reached here");

var schedules = JSON.parse(localStorage.nepalLoadsheddingSchedule);
var ss = new Time(0,0)

function show() {
	var group = 5;
	var sunScheduleIndex = group == 1 ? 0 : 8 - group;
	var status = getScheduleStatus(21, 37, 4, sunScheduleIndex)
	var notification = webkitNotifications.createNotification(
			'icons/bulbOn.png', // icon url - can be relative
			'!!! LOADSHEDDING ALERT !!!', // notification title
			//schedules[0][0][0] + schedules[0][0][3]  // notification body text
			status.status + " " + status.hoursRemaining + " " + status.minutesRemaining
			
	);
	notification.show();
}

var interval = 1000 * 10;
if (webkitNotifications) {
	setInterval(show, interval);
}

function getScheduleStatus(hour, minute, day, sundayScheduleIndex) {
	//console.log("retrieving status....");
	var status = new Status();
	var schedule;
	var dayScheduleIndex = (sundayScheduleIndex + day) % 7;
	
	for(var i = 0; i < schedules[dayScheduleIndex].length; i++) {
		
		var fromHour = schedules[dayScheduleIndex][i][0];
		var fromMinute = schedules[dayScheduleIndex][i][1];
		var toHour = schedules[dayScheduleIndex][i][2];
		var toMinute = schedules[dayScheduleIndex][i][3];
		
		var from = new Time(fromHour, fromMinute);
		var to = new Time(toHour, toMinute);
		var currentSchedule = new Schedule(from, to);
		if (currentSchedule.includes(hour, minute)) {
			status.status = 0;
			schedule = currentSchedule;
			break;
		}
	}
	
	if ( schedule == undefined ) { // light is on
		// find next schedule
		console.log("Light is on");
		for(var i = 0; i < schedules[dayScheduleIndex].length; i++) {
			var fromHour = schedules[dayScheduleIndex][i][0];
			var fromMinute = schedules[dayScheduleIndex][i][1];
			var toHour = schedules[dayScheduleIndex][i][2];
			var toMinute = schedules[dayScheduleIndex][i][3];
			
			var from = new Time(fromHour, fromMinute);
			var to = new Time(toHour, toMinute);
			var currentSchedule = new Schedule(from, to);
			if (currentSchedule.liesBelow(hour, minute)) {
				status.status = 1;
				schedule = currentSchedule;
				break;
			}
		}
	}
	
	if (schedule == undefined) {
		console.log("no schedule today")
		var time = getNextDayFirstSchedule(1, day, sundayScheduleIndex);
		var todayRemaining = getTodayRemaining(hour, minute);
		status.status = 1;
		status.hoursRemaining = todayRemaining.hour + time.hour;
		status.minutesRemaining = todayRemaining.minute + time.minute;
		
	}else {
		if (status.status == 0) {
			var nextDayTimeRemaining;
			if ( schedule.to.hour == 24 ) {
				nextDayTimeRemaining = getNextDayFirstSchedule(0, day, sundayScheduleIndex);
			} else {
				nextDayTimeRemaining = new Time(0, 0);
			}
			var timeDiff = getTimeDifference(schedule.to, new Time(hour, minute));
			
			status.hoursRemaining = timeDiff.hour + nextDayTimeRemaining.hour;
			status.minutesRemaining = timeDiff.minute + nextDayTimeRemaining.minute;
		} else {
			var timeDiff = getTimeDifference(schedule.from, new Time(hour, minute));
			status.hoursRemaining = timeDiff.hour;
			status.minutesRemaining = timeDiff.minute;
		}
	}
	return status;
	
}

function Time(hour, minute) {
	this.hour = hour;
	this.minute = minute;
	
	Time.prototype.isSmallerThan = function(hour, minute) {
		if( this.hour < hour ) {
			return true;
		} else if( this.hour > hour) {
			return false;
		} else {
			return this.minute < minute;
		}
	}
	
	Time.prototype.isLargerThan = function(hour, minute) {
		if ( this.hour > hour ) {
			return true;
		} else if ( this.hour < hour ) {
			return false;
		} else {
			return this.minute > minute;
		}
	}
	
	Time.prototype.isEqual = function(hour, minute) {
		return this.hour == hour && this.minute == minute;
	}
}

function Status() {
	this.status = 0;
	this.hoursRemaining = 0;
	this.minutesRemaining = 0;
}

function Schedule(from, to) {
	this.from = from;
	this.to = to;
	
	Schedule.prototype.includes = function(hour, minute) {
		return (this.from.isSmallerThan(hour, minute) || this.from.isEqual(hour, minute))
				&& (this.to.isLargerThan(hour, minute) || this.to.isEqual(hour, minute));
		
	}

	Schedule.prototype.liesBelow = function(hour, minute) {
		return this.from.isLargerThan(hour, minute);
	}
}

function getNextDayFirstSchedule(status, today, sundayScheduleIndex) {
	var time = new Time(0, 0);
	var scheduleFound = false;
	for (var i = 1; i < 7; i++) {
		var daySchedules = schedules[(sundayScheduleIndex + today + i) % 7];
		if (daySchedules.length > 0) {
			scheduleFound = true;
			var fromHour = daySchedules[0][0];
			var fromMinute = daySchedules[0][1];
			var toHour = daySchedules[0][2];
			var toMinute = daySchedules[0][3];
			console.log("logging...")
			console.log(fromHour)
			console.log(fromMinute)
			console.log(toHour)
			console.log(toMinute)
			
			var from = new Time(fromHour, fromMinute);
			var to = new Time(toHour, toMinute);
			var currentSchedule = new Schedule(from, to);
			if ( status == 0 && currentSchedule.from.hour != 0 ) {
				return time;
			}
			
			if ( status == 1 ) {
				time.hour = time.hour + currentSchedule.from.hour;
				time.minute = time.minute + currentSchedule.from.minute;
				//TODO
				//console.log(time.minute)
				break;
			} else {
				time.hour = time.hour + currentSchedule.to.hour;
				time.minute = time.minute + currentSchedule.to.minute;
				break;
			}
		} else {
			time.hour = time.hour + 24;
		}
	}
	return time;
}

function getTodayRemaining(hour, minute) {
	var time = new Time(0, 0);
	if ( minute > 0 ) {
		time.hour = 23 - hour;
		time.minute = 60 - minute;
	} else {
		time.hour = 24 - hour;
	}
	return time;
}

function getTimeDifference(time1, time2) {
	var time = new Time(0, 0);
	var minutesRemaining = time1.minute - time2.minute;
	if (minutesRemaining >= 0) {
		time.hour = time1.hour - time2.hour;
	} else {
		time.hour = time1.hour - time2.hour - 1;
		minutesRemaining += 60;
	}
	time.minute = minutesRemaining;
	return time;
}
//TODO
// Selected Group is localStorage.nepalLoadsheddingGroup
// 
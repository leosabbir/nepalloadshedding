//alert("reached here");
//TODO after user changes group selection getcurrent id (returned by setInterval) call setInterval again
var schedules = JSON.parse(localStorage.nepalLoadsheddingSchedule);
var id;
var firstRun = true;
var notification;

function show() {
	console.log("starting...")
	var group = localStorage.nepalLoadsheddingGroup;
	var prevGroup = localStorage.prevGroup;
	
	//TEST only
	//group = 1;
	var sunScheduleIndex = group == 1 ? 0 : 8 - group;
	
	var date = new Date();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var day = date.getDay();
	
	//TEST only
	//hour = 9;
	//minute = 48;
	//day = 6;
	
	var status = getScheduleStatus(hour, minute, day, sunScheduleIndex)
	var msg;
	if (status.status == 0) {
		if (firstRun || (status.hoursRemaining == 0 && status.minutesRemaining <= 10)) {
			msg = "Light will come after " + status.hoursRemaining + " hr " + status.minutesRemaining + " min";
			firstRun = false;
		}
	} else {
		if (firstRun || (status.hoursRemaining == 0 && status.minutesRemaining <= 10)) {
			msg = "Light will remain for " + status.hoursRemaining + " hr " + status.minutesRemaining + " min";
			firstRun = false;
		}
	}
	
	var intervalMinute = 1;
	console.log(status.hoursRemaining + " hr " + status.minutesRemaining + " min")
	if ( msg != undefined && prevGroup != group) {
		if ( notification != undefined ) {
			notification.cancel();
		}
		
		notification = webkitNotifications.createNotification(
			'icons/bulbOn.png', // icon url - can be relative
			'!!! LOADSHEDDING ALERT !!!', // notification title
			//schedules[0][0][0] + schedules[0][0][3]  // notification body text
			//status.status + " " + status.hoursRemaining + " " + status.minutesRemaining
			"Selected Group: " + group + "\n" + msg
			
		);
		
		notification.show();
	}
//	var interval = ( status.hoursRemaining * 60 * 60 + status.minutesRemaining * 60 - 10 * 60) * 1000;
//	if ( interval <= 0) {
//		console.log("negative")
//		console.log(interval)
//		//TODO get next interval
//		var minutesRemaining = status.minutesRemaining;
//		minute += minutesRemaining + 1;
//		if (minute >= 60 ) {
//			minute -= 60;
//			hour += 1;
//		}
//		status = getScheduleStatus(hour, minute + minutesRemaining, day, sunScheduleIndex)
//		interval = ( status.hoursRemaining * 60 * 60 + status.minutesRemaining * 60 + minutesRemaining * 60) * 1000;
//		console.log(interval)
//	}
	
	clearInterval(id);
	//id = setInterval(show, interval);
	id = setInterval(show, intervalMinute * 5 * 1000);
	//console.log("next alert after: " + (interval/(1000*60)) + " minutes")
	
	//notification.show();
	//notification.close();
	prevGroup = group;
	localStorage.prevGroup = group;
}

if (webkitNotifications) {
	show();
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
						
			var from = new Time(fromHour, fromMinute);
			var to = new Time(toHour, toMinute);
			var currentSchedule = new Schedule(from, to);
			if ( status == 0 && currentSchedule.from.hour != 0 ) {
				return time;
			}
			
			if ( status == 1 ) {
				time.hour = time.hour + currentSchedule.from.hour;
				time.minute = time.minute + currentSchedule.from.minute;
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
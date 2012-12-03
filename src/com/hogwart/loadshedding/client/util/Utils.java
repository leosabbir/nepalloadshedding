package com.hogwart.loadshedding.client.util;

import java.util.List;

import com.hogwart.loadshedding.client.ds.LoadsheddingDataSource;
import com.hogwart.loadshedding.client.model.LoadsheddingStatus;
import com.hogwart.loadshedding.client.model.ScheduleFromTo;
import com.hogwart.loadshedding.client.model.Time;

public class Utils {

	public static LoadsheddingStatus getLoadsheddingStatus(
			List<ScheduleFromTo> schedules, int hour, int minute, int day, int sunScheduleIndex) {
		LoadsheddingStatus status = new LoadsheddingStatus();
		ScheduleFromTo schedule = null;
		
		for (ScheduleFromTo scheduleLength : schedules) {
			if (scheduleLength.includes(hour, minute)) {
				schedule = scheduleLength;
				status.setOnOff(0);
				break;
			}
		}

		if (schedule == null) { // light is on
			// find next schedule;
			for (ScheduleFromTo scheduleLength : schedules) {
				if (scheduleLength.liesBelow(hour, minute)) {
					schedule = scheduleLength;
					status.setOnOff(1);
					break;
				}
			}
		}
		/*schedule null means there is no next loadshedding schedule today*/
		if (schedule == null) {
			Time time = LoadsheddingDataSource.getRemainingTime(day, sunScheduleIndex);
			Time todayRemaining = getTodayRemainingTime(hour, minute);
			status.setOnOff(1);
			status.setHourRemaining(todayRemaining.getHour() + time.getHour());
			status.setMinuteRemaining(todayRemaining.getMinute() + time.getMinute());
			
		} else {
			if (status.getOnOff() == 0) {
				Time timeDiff = getTimeDifference(schedule.getToTime(), new Time(hour, minute));
				status.setHourRemaining(timeDiff.getHour());
				status.setMinuteRemaining(timeDiff.getMinute());
			} else {
				Time timeDiff = getTimeDifference(schedule.getFromTime(), new Time(hour, minute));
				status.setHourRemaining(timeDiff.getHour());
				status.setMinuteRemaining(timeDiff.getMinute());
			}
		}
		return status;
	}
	
	private static Time getTimeDifference(Time time1, Time time2) {
		Time time = new Time(0, 0);
		int minutesRemaining = time1.getMinute() - time2.getMinute();
		if (minutesRemaining >= 0) {
			time.setHour(time1.getHour() - time2.getHour());
		} else {
			time.setHour(time1.getHour() - time2.getHour() - 1);
			minutesRemaining += 60;
		}
		time.setMinute(minutesRemaining);
		return time;
	}

	private static Time getTodayRemainingTime(int hour, int minute) {
		Time time = new Time(0, 0);
		if ( minute > 0 ) {
			time.setHour( 23 - hour);
			time.setMinute( 60 - minute);
		} else {
			time.setHour( 24 - hour);
		}
		return time;
	}
	
	public static int getGroupNumber(String str) {
		int groupNumber = Integer.parseInt(str.substring(str.length()-1));
		return groupNumber;
	}

}

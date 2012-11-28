package com.hogwart.loadshedding.client.ds;

import java.util.ArrayList;
import java.util.List;

import com.hogwart.loadshedding.client.model.ScheduleLength;
import com.hogwart.loadshedding.client.model.Time;

public class LoadsheddingDataSource {
	
	public static List<List<ScheduleLength>> getMockedData() {
		List<List<ScheduleLength>> schedules = new ArrayList<List<ScheduleLength>>();
		
		List<ScheduleLength> singleDaySchedule = new ArrayList<ScheduleLength>();
		ScheduleLength scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		singleDaySchedule = new ArrayList<ScheduleLength>();
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		singleDaySchedule = new ArrayList<ScheduleLength>();
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		singleDaySchedule = new ArrayList<ScheduleLength>();
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		singleDaySchedule = new ArrayList<ScheduleLength>();
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		singleDaySchedule = new ArrayList<ScheduleLength>();
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		singleDaySchedule = new ArrayList<ScheduleLength>();
		scheduleLength = new ScheduleLength();
		scheduleLength.setFromTime(getTime(6, 0, 0));
		scheduleLength.setToTime(getTime(9, 0, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		return schedules;
	}
	
	private static Time getTime(int hour, int minute, int ampm) {
		Time time = new  Time();
		time.setHour(hour);
		time.setMinute(minute);
		time.setAMPM(ampm);
		
		return time;
	}

}

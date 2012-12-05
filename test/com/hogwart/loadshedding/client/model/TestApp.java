package com.hogwart.loadshedding.client.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hogwart.loadshedding.client.ds.LoadsheddingDataConstructor;
import com.hogwart.loadshedding.client.util.Utils;

public class TestApp {
	
	private static List<List<ScheduleFromTo>> schedules = new ArrayList<List<ScheduleFromTo>>();
	
	public static List<List<ScheduleFromTo>> getMockedData() {
		
		//Sunday
		List<ScheduleFromTo> singleDaySchedule = new ArrayList<ScheduleFromTo>();
		ScheduleFromTo scheduleLength = new ScheduleFromTo(new Time(0, 0), new Time(6, 0));
		//singleDaySchedule.add(scheduleLength);
		
		scheduleLength = new ScheduleFromTo(new Time(12, 30), new Time(16, 0));
		//singleDaySchedule.add(scheduleLength);
		
		scheduleLength = new ScheduleFromTo(new Time(20, 30), new Time(22, 30));
		//singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		
		//Monday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(6, 0), new Time(9, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		//Tuesday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(8, 15), new Time(22, 10));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		
		//Wednesday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(2, 0), new Time(7, 0));
		singleDaySchedule.add(scheduleLength);

		scheduleLength = new ScheduleFromTo(new Time(19, 0), new Time(24, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		
		//Thursday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(0, 0), new Time(5, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		
		//Friday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(9, 0), new Time(21, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		
		//Saturday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(22, 0), new Time(24, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
		
		return schedules;
	}
	
	@Test
	public void testApp() {
		List<List<ScheduleFromTo>> schedules = getMockedData();
		LoadsheddingDataConstructor.setData(schedules);
		
		int day = 0;
		int hour = 21;
		int minute = 0;
		LoadsheddingStatus status = Utils.getLoadsheddingStatus(schedules.get(day), hour, minute, day, 1);
		
		Assert.assertEquals(1, status.getOnOff());
		Assert.assertEquals(11, status.getHourRemaining());
		Assert.assertEquals(15, status.getMinuteRemaining());
	}

}

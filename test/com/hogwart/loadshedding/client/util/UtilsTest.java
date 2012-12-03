package com.hogwart.loadshedding.client.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.hogwart.loadshedding.client.model.LoadsheddingStatus;
import com.hogwart.loadshedding.client.model.ScheduleFromTo;
import com.hogwart.loadshedding.client.model.Time;

public class UtilsTest {
	
	@Test
	public void getLoadsheddingStatus() {
		List<ScheduleFromTo> singleDaySchedule = new ArrayList<ScheduleFromTo>();
		ScheduleFromTo scheduleLength = new ScheduleFromTo(new Time(6, 0), new Time(9, 0));
		singleDaySchedule.add(scheduleLength);
		
		scheduleLength = new ScheduleFromTo(new Time(18, 0), new Time(22, 0));
		singleDaySchedule.add(scheduleLength);
		
//		scheduleLength = new ScheduleFromTo(new Time(6, 0), new Time(9, 0));
//		singleDaySchedule.add(scheduleLength);
		
		LoadsheddingStatus status = Utils.getLoadsheddingStatus(singleDaySchedule, 7, 0, -1, 0);
		Assert.assertEquals(0, status.getOnOff());
		Assert.assertEquals(2, status.getHourRemaining());
		Assert.assertEquals(0, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 8, 23, -1, 0);
		Assert.assertEquals(0, status.getOnOff());
		Assert.assertEquals(0, status.getHourRemaining());
		Assert.assertEquals(37, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 8, 58, -1, 0);
		Assert.assertEquals(0, status.getOnOff());
		Assert.assertEquals(0, status.getHourRemaining());
		Assert.assertEquals(2, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 7, 58, -1, 0);
		Assert.assertEquals(0, status.getOnOff());
		Assert.assertEquals(1, status.getHourRemaining());
		Assert.assertEquals(2, status.getMinuteRemaining());
	}
	
	@Test
	public void getLoadsheddingStatus2() {
		List<ScheduleFromTo> singleDaySchedule = new ArrayList<ScheduleFromTo>();
		ScheduleFromTo scheduleLength = new ScheduleFromTo(new Time(6, 0), new Time(9, 10));
		singleDaySchedule.add(scheduleLength);
		
		scheduleLength = new ScheduleFromTo(new Time(18, 0), new Time(22, 0));
		singleDaySchedule.add(scheduleLength);
		
//		scheduleLength = new ScheduleFromTo(new Time(6, 0), new Time(9, 0));
//		singleDaySchedule.add(scheduleLength);
		
		LoadsheddingStatus status = Utils.getLoadsheddingStatus(singleDaySchedule, 7, 0, -1, 0);
		Assert.assertEquals(0, status.getOnOff());
		Assert.assertEquals(2, status.getHourRemaining());
		Assert.assertEquals(10, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 8, 23, -1, 0);
		Assert.assertEquals(0, status.getOnOff());
		Assert.assertEquals(0, status.getHourRemaining());
		Assert.assertEquals(47, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 8, 58, -1, 0);
		Assert.assertEquals(0, status.getOnOff());
		Assert.assertEquals(0, status.getHourRemaining());
		Assert.assertEquals(12, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 7, 58, -1, 0);
		Assert.assertEquals(0, status.getOnOff());
		Assert.assertEquals(1, status.getHourRemaining());
		Assert.assertEquals(12, status.getMinuteRemaining());
	}
	
	@Test
	public void getLoadsheddingStatus3() {
		List<ScheduleFromTo> singleDaySchedule = new ArrayList<ScheduleFromTo>();
		ScheduleFromTo scheduleLength = new ScheduleFromTo(new Time(6, 0), new Time(9, 10));
		singleDaySchedule.add(scheduleLength);
		
		scheduleLength = new ScheduleFromTo(new Time(18, 0), new Time(22, 0));
		singleDaySchedule.add(scheduleLength);
		
		LoadsheddingStatus status = Utils.getLoadsheddingStatus(singleDaySchedule, 13, 00, -1, 0);
		Assert.assertEquals(1, status.getOnOff());
		Assert.assertEquals(5, status.getHourRemaining());
		Assert.assertEquals(0, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 17, 23, -1, 0);
		Assert.assertEquals(1, status.getOnOff());
		Assert.assertEquals(0, status.getHourRemaining());
		Assert.assertEquals(37, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 16, 58, -1, 0);
		Assert.assertEquals(1, status.getOnOff());
		Assert.assertEquals(1, status.getHourRemaining());
		Assert.assertEquals(2, status.getMinuteRemaining());
	}
	
	@Test
	public void getLoadsheddingStatus4() {
		List<ScheduleFromTo> singleDaySchedule = new ArrayList<ScheduleFromTo>();
		ScheduleFromTo scheduleLength = new ScheduleFromTo(new Time(6, 0), new Time(9, 10));
		singleDaySchedule.add(scheduleLength);
		
		scheduleLength = new ScheduleFromTo(new Time(18, 30), new Time(22, 0));
		singleDaySchedule.add(scheduleLength);
		
		LoadsheddingStatus status = Utils.getLoadsheddingStatus(singleDaySchedule, 13, 00, -1, 0);
		Assert.assertEquals(1, status.getOnOff());
		Assert.assertEquals(5, status.getHourRemaining());
		Assert.assertEquals(30, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 17, 23, -1, 0);
		Assert.assertEquals(1, status.getOnOff());
		Assert.assertEquals(1, status.getHourRemaining());
		Assert.assertEquals(7, status.getMinuteRemaining());
		
		status = Utils.getLoadsheddingStatus(singleDaySchedule, 16, 58, -1, 0);
		Assert.assertEquals(1, status.getOnOff());
		Assert.assertEquals(1, status.getHourRemaining());
		Assert.assertEquals(32, status.getMinuteRemaining());
	}
	
	@Test
	public void getNumberTest() {
		Assert.assertEquals(4, Utils.getGroupNumber("asfasf4"));
		Assert.assertEquals(4, Utils.getGroupNumber("asfasfaq34534"));
		Assert.assertEquals(3, Utils.getGroupNumber("asfasf434543"));
		Assert.assertEquals(7, Utils.getGroupNumber("asfasf4567"));
		Assert.assertEquals(3, Utils.getGroupNumber("asfasf4123"));
		Assert.assertEquals(6, Utils.getGroupNumber("asfasf4456"));
	}

}

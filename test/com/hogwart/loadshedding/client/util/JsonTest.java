package com.hogwart.loadshedding.client.util;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.junit.client.GWTTestCase;
import com.hogwart.loadshedding.client.ds.JSONMockedSchedule;
import com.hogwart.loadshedding.client.ds.LoadsheddingDataConstructor;
import com.hogwart.loadshedding.client.model.ScheduleFromTo;

public class JsonTest extends GWTTestCase {
	
	@Test
	public void test() throws Exception {
		JSONArray obj = (JSONArray) JSONParser.parseStrict(JSONMockedSchedule.SCHEDULE);
		Assert.assertNotNull(obj);
		
		LoadsheddingDataConstructor.setSchedulesFromJSON(JSONMockedSchedule.SCHEDULE);
		
		Assert.assertEquals(7, LoadsheddingDataConstructor.getSchedules().size());
		
		for( int i = 0; i < 7; i++ ) {
			List<ScheduleFromTo> daySchedules = LoadsheddingDataConstructor.getSchedules().get(i);
			
			Assert.assertEquals(2, daySchedules.size());
			
			ScheduleFromTo firstSchedule = daySchedules.get(0);
			ScheduleFromTo secondSchedule = daySchedules.get(1);
			
			switch (i) {
			case 0:
				this.confirmValues(firstSchedule, 5, 0, 9, 0);
				this.confirmValues(secondSchedule, 13, 0, 17, 0);
				break;
			case 1:
				this.confirmValues(firstSchedule, 12, 0, 16, 30);
				this.confirmValues(secondSchedule, 19, 30, 23, 0);
				break;
			case 2:
				this.confirmValues(firstSchedule, 11, 0, 15, 0);
				this.confirmValues(secondSchedule, 19, 0, 22, 0);
				break;
			case 3:
				this.confirmValues(firstSchedule, 9, 0, 13, 0);
				this.confirmValues(secondSchedule, 17, 0, 21, 0);
				break;
			case 4:
				this.confirmValues(firstSchedule, 7, 30, 12, 0);
				this.confirmValues(secondSchedule, 17, 0, 20, 30);
				break;
			case 5:
				this.confirmValues(firstSchedule, 6, 0, 11, 0);
				this.confirmValues(secondSchedule, 16, 30, 19, 30);
				break;
			default:
				this.confirmValues(firstSchedule, 5, 0, 10, 0);
				this.confirmValues(secondSchedule, 15, 0, 19, 0);
				break;
			}
		}
	}
	
	private void confirmValues(ScheduleFromTo schedule, int fhour, int fmin, int thour, int tmin) {
		Assert.assertEquals(fhour, schedule.getFromTime().getHour());
		Assert.assertEquals(fmin, schedule.getFromTime().getMinute());
		Assert.assertEquals(thour, schedule.getToTime().getHour());
		Assert.assertEquals(tmin, schedule.getToTime().getMinute());
	}

	@Override
	public String getModuleName() {
		return "com.hogwart.loadshedding.Nepalloadshedding";
	}

}

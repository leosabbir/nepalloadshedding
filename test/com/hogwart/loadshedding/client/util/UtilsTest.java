package com.hogwart.loadshedding.client.util;

import junit.framework.Assert;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;
import com.hogwart.loadshedding.client.bind.ClientFactory;
import com.hogwart.loadshedding.client.ds.LoadsheddingDataConstructor;
import com.hogwart.loadshedding.client.ds.TestSchedules;
import com.hogwart.loadshedding.client.model.LoadsheddingStatus;

public class UtilsTest extends GWTTestCase {
	
	private void testStatus( LoadsheddingStatus status, int expectedStatus, int expectedRemainingHours, int expectedRemainingMinutes) {
		Assert.assertEquals(expectedStatus, status.getOnOff());
		Assert.assertEquals(expectedRemainingHours, status.getHourRemaining());
		Assert.assertEquals(expectedRemainingMinutes, status.getMinuteRemaining());
	}
	
	@Test
	public void testGetLoadsheddingStatus() throws Exception {
		LoadsheddingDataConstructor.setSchedulesFromJSON(TestSchedules.SCHEDULE);
		
		//Sunday
		int day = 0;
		LoadsheddingStatus status = Utils.getLoadsheddingStatus( 1, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 2, 0);
		status = Utils.getLoadsheddingStatus( 2, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus( 5, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		status = Utils.getLoadsheddingStatus( 7, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 0);
		status = Utils.getLoadsheddingStatus( 10, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 3, 0);
		status = Utils.getLoadsheddingStatus( 12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus( 13, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 5, 30);
		status = Utils.getLoadsheddingStatus( 17, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 0);
		status = Utils.getLoadsheddingStatus( 21, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 13, 0);
		status = Utils.getLoadsheddingStatus( 22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 11, 15);
		
		//Monday
		day = 1;
		status = Utils.getLoadsheddingStatus( 1, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 9, 0);
		status = Utils.getLoadsheddingStatus( 5, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 4, 35);
		status = Utils.getLoadsheddingStatus( 10, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 6, 30);
		status = Utils.getLoadsheddingStatus( 14, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 0);
		status = Utils.getLoadsheddingStatus( 18, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 2, 0);
		status = Utils.getLoadsheddingStatus( 19, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus( 21, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		status = Utils.getLoadsheddingStatus( 23, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 0);

		// Tuesday
		day = 2;
		status = Utils.getLoadsheddingStatus(7, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 35);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		status = Utils.getLoadsheddingStatus(17, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		
		//Wednesday
		day = 3;
		status = Utils.getLoadsheddingStatus(7, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(17, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
	
		//Thursday
		day = 4;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 35);
		status = Utils.getLoadsheddingStatus(10, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(16, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 5, 15);
		
		
		//Friday
		day = 5;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus(9, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(13, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 2, 30);
		status = Utils.getLoadsheddingStatus(18, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 5, 15);
		
		//Saturday
		day = 6;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus(9, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 0, 30);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 30);
		status = Utils.getLoadsheddingStatus(19, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 0, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 4, 15);
	}
	
	@Test
	public void testGetLoadsheddingStatus2() throws Exception {
		LoadsheddingDataConstructor.setSchedulesFromJSON(TestSchedules.SCHEDULE2);
		
		//Sunday
		int day = 0;
		LoadsheddingStatus status = Utils.getLoadsheddingStatus( 1, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 2, 0);
		status = Utils.getLoadsheddingStatus( 2, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus( 5, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		status = Utils.getLoadsheddingStatus( 7, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 0);
		status = Utils.getLoadsheddingStatus( 10, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 3, 0);
		status = Utils.getLoadsheddingStatus( 12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus( 13, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 5, 30);
		status = Utils.getLoadsheddingStatus( 17, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 0);
		status = Utils.getLoadsheddingStatus( 21, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 13, 0);
		status = Utils.getLoadsheddingStatus( 22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 11, 15);
		
		//Monday
		day = 1;
		status = Utils.getLoadsheddingStatus( 1, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 9, 0);
		status = Utils.getLoadsheddingStatus( 5, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 4, 35);
		status = Utils.getLoadsheddingStatus( 10, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 6, 30);
		status = Utils.getLoadsheddingStatus( 14, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 0);
		status = Utils.getLoadsheddingStatus( 18, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 2, 0);
		status = Utils.getLoadsheddingStatus( 19, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus( 21, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 30);
		status = Utils.getLoadsheddingStatus( 23, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 0);

		// Tuesday
		day = 2;
		status = Utils.getLoadsheddingStatus(7, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 35);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		status = Utils.getLoadsheddingStatus(17, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		
		//Wednesday
		day = 3;
		status = Utils.getLoadsheddingStatus(7, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(17, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
	
		//Thursday
		day = 4;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 35);
		status = Utils.getLoadsheddingStatus(10, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(16, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 5, 15);
		
		
		//Friday
		day = 5;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus(9, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(13, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 2, 30);
		status = Utils.getLoadsheddingStatus(18, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 5, 15);
		
		//Saturday
		day = 6;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus(9, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 0, 30);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 30);
		status = Utils.getLoadsheddingStatus(19, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 0, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 4, 15);
	}
	
	@Test
	public void testGetLoadsheddingStatus3() throws Exception {
		LoadsheddingDataConstructor.setSchedulesFromJSON(TestSchedules.SCHEDULE3);
		
		//Sunday
		int day = 0;
		LoadsheddingStatus status = Utils.getLoadsheddingStatus( 1, 0, day, 0);
		testStatus(status, 1, 2, 0);
		status = Utils.getLoadsheddingStatus( 2, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 35);
		status = Utils.getLoadsheddingStatus( 5, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		status = Utils.getLoadsheddingStatus( 7, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 0);
		status = Utils.getLoadsheddingStatus( 10, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 3, 0);
		status = Utils.getLoadsheddingStatus( 12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus( 13, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 5, 30);
		status = Utils.getLoadsheddingStatus( 17, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 2, 0);
		status = Utils.getLoadsheddingStatus( 21, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 27, 0);
		status = Utils.getLoadsheddingStatus( 22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 25, 15);
		
		//Monday
		day = 1;
		status = Utils.getLoadsheddingStatus( 1, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 23, 0);
		status = Utils.getLoadsheddingStatus( 5, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 18, 35);
		status = Utils.getLoadsheddingStatus( 10, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 13, 30);
		status = Utils.getLoadsheddingStatus( 14, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 10, 0);
		status = Utils.getLoadsheddingStatus( 18, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 6, 0);
		status = Utils.getLoadsheddingStatus( 19, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 4, 30);
		status = Utils.getLoadsheddingStatus( 21, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 2, 30);
		status = Utils.getLoadsheddingStatus( 23, 0, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 0);

		// Tuesday
		day = 2;
		status = Utils.getLoadsheddingStatus(7, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 35);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 3, 30);
		status = Utils.getLoadsheddingStatus(17, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 27, 30);
		
		//Wednesday
		day = 3;
		status = Utils.getLoadsheddingStatus(7, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 21, 35);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 16, 30);
		status = Utils.getLoadsheddingStatus(17, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 11, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 8, 30);
	
		//Thursday
		day = 4;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 1, 35);
		status = Utils.getLoadsheddingStatus(10, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(16, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 0, 30);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 0, 1, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 52, 15);
		
		
		//Friday
		day = 5;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 47, 35);
		status = Utils.getLoadsheddingStatus(9, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 41, 30);
		status = Utils.getLoadsheddingStatus(13, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 37, 30);
		status = Utils.getLoadsheddingStatus(18, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 32, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 28, 15);
		
		//Saturday
		day = 6;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 23, 35);
		status = Utils.getLoadsheddingStatus(9, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 17, 30);
		status = Utils.getLoadsheddingStatus(12, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 14, 30);
		status = Utils.getLoadsheddingStatus(19, 30, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 7, 30);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertFalse(ClientFactory.isNoLoadsheddin());
		testStatus(status, 1, 4, 15);
	}
	
	@Test
	public void testGetLoadsheddingStatus4() throws Exception {
		LoadsheddingDataConstructor.setSchedulesFromJSON(TestSchedules.SCHEDULE4);
		
		//Sunday
		int day = 0;
		LoadsheddingStatus status = Utils.getLoadsheddingStatus( 1, 0, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 2, 0);
		status = Utils.getLoadsheddingStatus( 22, 45, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 25, 15);
		
		//Monday
		day = 1;
		status = Utils.getLoadsheddingStatus( 1, 0, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 23, 0);
		status = Utils.getLoadsheddingStatus( 23, 0, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 1, 0);

		// Tuesday
		day = 2;
		status = Utils.getLoadsheddingStatus(7, 25, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 1, 35);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 27, 30);
		
		//Wednesday
		day = 3;
		status = Utils.getLoadsheddingStatus(7, 25, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 21, 35);
		status = Utils.getLoadsheddingStatus(20, 30, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 8, 30);
	
		//Thursday
		day = 4;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 1, 35);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 52, 15);
		
		
		//Friday
		day = 5;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
		//testStatus(status, 1, 47, 35);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
		//testStatus(status, 1, 28, 15);
		
		//Saturday
		day = 6;
		status = Utils.getLoadsheddingStatus(3, 25, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
	//	testStatus(status, 1, 23, 35);
		status = Utils.getLoadsheddingStatus(22, 45, day, 0);
		Assert.assertTrue(ClientFactory.isNoLoadsheddin());
//		testStatus(status, 1, 4, 15);
	}
	
	
	
	@Test
	public void testGetNumberTest() {
		Assert.assertEquals(4, Utils.getGroupNumber("asfasf4"));
		Assert.assertEquals(4, Utils.getGroupNumber("asfasfaq34534"));
		Assert.assertEquals(3, Utils.getGroupNumber("asfasf434543"));
		Assert.assertEquals(7, Utils.getGroupNumber("asfasf4567"));
		Assert.assertEquals(3, Utils.getGroupNumber("asfasf4123"));
		Assert.assertEquals(6, Utils.getGroupNumber("asfasf4456"));
	}

	@Override
	public String getModuleName() {
		return "com.hogwart.loadshedding.Nepalloadshedding";
	}

}

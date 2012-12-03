package com.hogwart.loadshedding.client.model;

import junit.framework.Assert;

import org.junit.Test;

public class ScheduleFromToTest {
	
	ScheduleFromTo schedule;
	
	public ScheduleFromToTest() {
		schedule = new ScheduleFromTo(new Time(5, 30), new Time(7, 0));
	}
	
	@Test
	public void TestIncludes() {
		Assert.assertTrue(this.schedule.includes(6, 0));
		
		Assert.assertFalse(this.schedule.includes(4, 40));
		Assert.assertFalse(this.schedule.includes(5, 29));
		Assert.assertTrue(this.schedule.includes(5, 30));
		Assert.assertTrue(this.schedule.includes(5, 31));
		Assert.assertTrue(this.schedule.includes(6, 0));
		
		Assert.assertTrue(this.schedule.includes(7, 0));
	}
	
	@Test
	public void TestLiesBelow() {
		Assert.assertTrue(this.schedule.liesBelow(4, 0));
		Assert.assertTrue(this.schedule.liesBelow(4, 30));
		Assert.assertTrue(this.schedule.liesBelow(4, 40));
		Assert.assertTrue(this.schedule.liesBelow(5, 29));
		Assert.assertFalse(this.schedule.liesBelow(5, 30));
		Assert.assertFalse(this.schedule.liesBelow(5, 31));
		Assert.assertFalse(this.schedule.liesBelow(6, 0));
		Assert.assertFalse(this.schedule.liesBelow(6, 30));
		Assert.assertFalse(this.schedule.liesBelow(6, 40));
	}

}

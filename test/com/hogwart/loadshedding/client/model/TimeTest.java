package com.hogwart.loadshedding.client.model;

import junit.framework.Assert;

import org.junit.Test;

public class TimeTest {
	
	Time time;
	
	public TimeTest() {
		time = new Time(5, 30);
	}
	
	@Test
	public void testIsSmallerThan() {
		Assert.assertTrue(this.time.isSmallerThan(6, 0));
		Assert.assertTrue(this.time.isSmallerThan(6, 30));
		Assert.assertTrue(this.time.isSmallerThan(6, 40));
		Assert.assertTrue(this.time.isSmallerThan(5, 31));
		
		Assert.assertFalse(this.time.isSmallerThan(5, 30));

		Assert.assertFalse(this.time.isSmallerThan(5, 29));
		Assert.assertFalse(this.time.isSmallerThan(4, 0));
		Assert.assertFalse(this.time.isSmallerThan(4, 30));
		Assert.assertFalse(this.time.isSmallerThan(4, 40));
	}
	
	@Test
	public void testIsLargerThan() {
		Assert.assertTrue(this.time.isLargerThan(4, 0));
		Assert.assertTrue(this.time.isLargerThan(5, 29));
		
		Assert.assertFalse(this.time.isLargerThan(5, 30));

		Assert.assertFalse(this.time.isLargerThan(5, 31));
		Assert.assertFalse(this.time.isLargerThan(6, 30));
	}
	
	@Test
	public void testIsEqualsThan() {
		Assert.assertFalse(this.time.isEqual(4, 0));
		Assert.assertFalse(this.time.isEqual(4, 0));
		Assert.assertFalse(this.time.isEqual(4, 0));
		Assert.assertFalse(this.time.isEqual(5, 29));
		
		Assert.assertTrue(this.time.isEqual(5, 30));

		Assert.assertFalse(this.time.isEqual(5, 31));
		Assert.assertFalse(this.time.isEqual(6, 0));
		Assert.assertFalse(this.time.isEqual(6, 30));
		Assert.assertFalse(this.time.isEqual(6, 40));
	}

}

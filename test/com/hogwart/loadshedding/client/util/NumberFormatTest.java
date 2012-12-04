package com.hogwart.loadshedding.client.util;

import junit.framework.Assert;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;

public class NumberFormatTest extends GWTTestCase{
	
	@Test
	public void test() {
		Assert.assertTrue( NumberFormatUtil.formatNumber(4).equals("04"));
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "com.hogwart.loadshedding.Nepalloadshedding";
	}

}

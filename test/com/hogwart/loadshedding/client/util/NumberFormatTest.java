package com.hogwart.loadshedding.client.util;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;

public class NumberFormatTest extends GWTTestCase{
	
	@Test
	public void test() {
		System.out.println(NumberFormatUtil.formatNumber(4));
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return null;
	}

}

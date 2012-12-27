package com.hogwart.loadshedding.client.ds;

public class JSONMockedSchedule {

	public static final String VERSION = "1.0.0:2068 / 00 / 00";
	
	public static final String SCHEDULE = 
			"[" +
				//SUN
				"[" +
					"[3,0,9,0]," +
					"[13,0,19,0]" +
				"],"	+
					
				//MON
				"[" +
					"[10,0,17,0]," +
					"[20,0,24,0]" +
				"],"	+
					
				//TUE
				"[" +
					"[0,0,1,0]," +
					"[9,0,16,0]," +
					"[19,0,24,0]" +
				"],"	+
					
				//WED
				"[" +
					"[8,0,14,0]," +
					"[18,0,24,0]" +
				"],"	+
					
				//THU
				"[" +
					"[5,0,12,0]," +
					"[17,0,22,0]" +
				"],"	+
					
				//FRI
				"[" +
					"[4,0,11,0]," +
					"[16,0,21,0]" +
				"],"	+
					
				//SAT
				"[" +
					"[4,0,10,0]," +
					"[14,0,20,0]" +
				"]"	+
					
				
			"]";
}

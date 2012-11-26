package com.hogwart.loadshedding.client.model;

public class ScheduleLength {
	
	private Time fromTime;
	private Time toTime;
	
	public Time getFromTime() {
		return fromTime;
	}
	
	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}
	
	public Time getToTime() {
		return toTime;
	}
	
	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}
	
	public String toString() {
		String str = "";
		
		str += fromTime.getHour() + " : " + fromTime.getMinute() + " " + fromTime.getAMPM() + " - " +
				toTime.getHour() + " : " + toTime.getMinute() + " " + toTime.getAMPM();
		
		return str;
	}
	

}

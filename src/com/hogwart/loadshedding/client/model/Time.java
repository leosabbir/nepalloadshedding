package com.hogwart.loadshedding.client.model;

public class Time {
	
	private int hour;
	private int minute;
	private int AMPM;
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public int getAMPM() {
		return AMPM;
	}
	
	public void setAMPM(int aMPM) {
		AMPM = aMPM;
	}
}

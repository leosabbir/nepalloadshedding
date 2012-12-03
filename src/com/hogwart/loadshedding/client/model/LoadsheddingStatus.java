package com.hogwart.loadshedding.client.model;

public class LoadsheddingStatus {

	private int onOff;
	private int hourRemaining;
	private int minuteRemaining;
	
	public int getOnOff() {
		return onOff;
	}
	
	public void setOnOff(int onOff) {
		this.onOff = onOff;
	}
	
	public int getHourRemaining() {
		return hourRemaining;
	}
	
	public void setHourRemaining(int hourRemaining) {
		this.hourRemaining = hourRemaining;
	}
	
	public int getMinuteRemaining() {
		return minuteRemaining;
	}
	
	public void setMinuteRemaining(int minuteRemaining) {
		this.minuteRemaining = minuteRemaining;
	}
	
	
}

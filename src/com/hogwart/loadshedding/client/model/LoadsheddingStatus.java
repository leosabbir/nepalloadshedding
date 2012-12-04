package com.hogwart.loadshedding.client.model;

import com.hogwart.loadshedding.client.util.NumberFormatUtil;

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
	
	public String getTime () {
		return NumberFormatUtil.formatNumber(this.hourRemaining) + " : " + NumberFormatUtil.formatNumber(this.minuteRemaining);
	}
	
}

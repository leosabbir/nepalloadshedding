package com.hogwart.loadshedding.client.model;

import com.hogwart.loadshedding.client.util.NumberFormatUtil;

public class Time {
	
	private int hour;
	private int minute;
	
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
	
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

	public boolean isSmallerThan(int hour, int minute) {
		if( this.hour < hour ) {
			return true;
		} else if( this.hour > hour) {
			return false;
		} else {
			return this.minute < minute;
		}
	}

	public boolean isLargerThan(int hour, int minute) {
		if ( this.hour > hour ) {
			return true;
		} else if ( this.hour < hour ) {
			return false;
		} else {
			return this.minute > minute;
		}
	}
	
	public boolean isEqual( int hour, int minute ) {
		return this.hour == hour && this.minute == minute;
	}
	
	@Override
	public String toString () {
		return NumberFormatUtil.formatNumber(this.hour) + " : " + NumberFormatUtil.formatNumber(this.minute);
	}
	
}

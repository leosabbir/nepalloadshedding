package com.hogwart.loadshedding.client.model;

public class ScheduleFromTo {
	
	public ScheduleFromTo( Time fromTime, Time toTime) {
		this.fromTime = fromTime;
		this.toTime = toTime;
	}
	
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
		
		str += fromTime.getHour() + " : " + fromTime.getMinute() + " - " +
				toTime.getHour() + " : " + toTime.getMinute();
		
		return str;
	}

	public boolean includes(int hour, int minute) {
		return (this.fromTime.isSmallerThan(hour, minute) || this.fromTime.isEqual(hour, minute))
				&& (this.toTime.isLargerThan(hour, minute) || this.toTime.isEqual(hour, minute));
		
	}

	public boolean liesBelow(int hour, int minute) {
		return this.fromTime.isLargerThan(hour, minute);
	}
	

}

package com.hogwart.loadshedding.client.model;

public class ScheduleFromTo {
	
	public static String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	
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
	
	@Override
	public String toString() {
		return fromTime.toString() + space + "to" + space + toTime.toString();
	}

	public boolean includes(int hour, int minute) {
		return (this.fromTime.isSmallerThan(hour, minute) || this.fromTime.isEqual(hour, minute))
				&& (this.toTime.isLargerThan(hour, minute) || this.toTime.isEqual(hour, minute));
		
	}

	public boolean liesBelow(int hour, int minute) {
		return this.fromTime.isLargerThan(hour, minute);
	}
	

}

package com.hogwart.loadshedding.client.util;

public class LocalStorageUtil {
	
	public static native void storeCurrentSelectedGroup (String group) /*-{
		localStorage.nepalLoadsheddingGroup = group;
	}-*/;
	
	public static native String getCurrentSelectedGroup () /*-{
		return localStorage.nepalLoadsheddingGroup;
	}-*/;
	
	public static native void storeCurrentSchedule(String schedule) /*-{
		localStorage.nepalLoadsheddingSchedule = schedule;
		localStorage.nepalLoadsheddingScheduleChanged = true;
	}-*/;
	
	public static native String getCurrentSchedule () /*-{
		return localStorage.nepalLoadsheddingSchedule;
	}-*/;
	
	public static native String getCurrentScheduleVersion () /*-{
		return localStorage.nepalLoadsheddingScheduleVersion;
	}-*/;
	
	public static native void storeCurrentScheduleVersion(String scheduleVersion) /*-{
		localStorage.nepalLoadsheddingScheduleVersion = scheduleVersion;
	}-*/;
	
	public static native void storeNotificationEnabled(boolean notificationEnabled) /*-{
		localStorage.nepalLoadsheddingNotificationEnabled = notificationEnabled;
	}-*/;

	public static native String getNotificationEnabled () /*-{
		return localStorage.nepalLoadsheddingNotificationEnabled;
	}-*/;
	
	public static native void storeNotificationTime(int notificationTime) /*-{
		localStorage.nepalLoadsheddingNotificationTime = notificationTime;
	}-*/;

	public static native String getNotificationTime () /*-{
		return localStorage.nepalLoadsheddingNotificationTime;
	}-*/;
	
	public static native String storeNotificationChanged (boolean changed) /*-{
		localStorage.nepalLoadsheddingNotificationChanged = changed;
	}-*/;

}

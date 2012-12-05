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
	}-*/;
	
	public static native String getCurrentSchedule () /*-{
		return localStorage.nepalLoadsheddingSchedule;
}-*/;

}

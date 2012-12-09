package com.hogwart.loadshedding.client.bind;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.hogwart.loadshedding.client.ds.JSONMockedSchedule;
import com.hogwart.loadshedding.client.util.DataExtractorUtil;
import com.hogwart.loadshedding.client.util.LocalStorageUtil;

public class ClientFactory {
	
	private static EventBus _eventBus;
	private static String _scheduleVersion;
	private static String _schedule;
	private static String _effectiveFrom;
	
	public static EventBus getEventBus () {
		if ( _eventBus == null ) {
			_eventBus = new SimpleEventBus();
		}
		return _eventBus;
	}
	
	public static void setScheduleVersion ( String scheduleVersion) throws Exception {
		String[] comps = scheduleVersion.split(":");
		_scheduleVersion = comps[0];
		_effectiveFrom = comps[1];
	}
	
	public static String getScheduleVersion () {
		return _scheduleVersion;
	}
	
	public static void setSchedule ( String schedule ) {
		_schedule = schedule;
	}

	public static String getSchedule () {
		return _schedule;
	}
	
	public static String getEffectiveFrom () {
		return _effectiveFrom;
	}
	
	public static void setEffectiveFrom (String effectiveFrom ) {
		_effectiveFrom = effectiveFrom;
	}
	
	public static void Reset () {
		LocalStorageUtil.storeCurrentScheduleVersion(JSONMockedSchedule.VERSION);
		try {
			ClientFactory.setScheduleVersion(JSONMockedSchedule.VERSION);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LocalStorageUtil.storeCurrentSchedule(JSONMockedSchedule.SCHEDULE);
		ClientFactory.setSchedule(JSONMockedSchedule.SCHEDULE);
		DataExtractorUtil.getScheduleVersion();
	}
	
}

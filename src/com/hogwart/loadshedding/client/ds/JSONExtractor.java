package com.hogwart.loadshedding.client.ds;

import com.hogwart.loadshedding.client.bind.ClientFactory;
import com.hogwart.loadshedding.client.util.LocalStorageUtil;

public class JSONExtractor {
	
	public static String extractJSON () {
		String jsonString;
		if ( updateAvailable() ) {
			jsonString = extractFromSource();
			LocalStorageUtil.storeCurrentSchedule(jsonString);
		} else {
			jsonString = LocalStorageUtil.getCurrentSchedule();
		}
		
		return jsonString;
	}
	
	private static String extractFromSource() {
		return ClientFactory.getSchedule();
	}

	public static boolean updateAvailable () {
		//TODO find if update exists
		return false;
	}

}

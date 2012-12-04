package com.hogwart.loadshedding.client.bind;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

public class ClientFactory {
	
	private static EventBus eventBus;
	
	public static EventBus getEventBus () {
		if ( eventBus == null ) {
			eventBus = new SimpleEventBus();
		}
		return eventBus;
	}

}

package com.hogwart.loadshedding.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DataReceivedEvent extends GwtEvent<DataReceivedEvent.Handler> {

	private String data;
	
	public DataReceivedEvent(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
	
	public static final GwtEvent.Type<Handler> TYPE = new GwtEvent.Type<Handler>();
	
	public interface Handler extends EventHandler {
		void onDataReceived(DataReceivedEvent event);
	}

	@Override
	public GwtEvent.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onDataReceived(this);
	}
}

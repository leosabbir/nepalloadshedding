package com.hogwart.loadshedding.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class GroupChangeEvent extends GwtEvent<GroupChangeEvent.Handler> {
	
	private int group;
	
	public GroupChangeEvent(int group) {
		this.group = group;
	}
	
	public int getGroup() {
		return this.group;
	}
	
	public interface Handler extends EventHandler {
		void onGroupChanged(GroupChangeEvent event);
	}


	public static final GwtEvent.Type<Handler> TYPE = new GwtEvent.Type<Handler>();


	@Override
	protected void dispatch(Handler handler) {
		handler.onGroupChanged(this);
	}

	@Override
	public GwtEvent.Type<Handler> getAssociatedType() {
		return TYPE;
	}
}

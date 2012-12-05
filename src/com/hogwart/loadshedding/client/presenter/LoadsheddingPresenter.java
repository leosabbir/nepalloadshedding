package com.hogwart.loadshedding.client.presenter;

import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.hogwart.loadshedding.client.ds.JSONExtractor;
import com.hogwart.loadshedding.client.ds.JSONMockedSchedule;
import com.hogwart.loadshedding.client.ds.LoadsheddingDataConstructor;
import com.hogwart.loadshedding.client.event.GroupChangeEvent;
import com.hogwart.loadshedding.client.model.ScheduleFromTo;
import com.hogwart.loadshedding.client.util.LocalStorageUtil;
import com.hogwart.loadshedding.client.view.ScheduleView;

public class LoadsheddingPresenter implements GroupChangeEvent.Handler {

	ScheduleView scheduleView;
	EventBus eventBus;
	
	
	public LoadsheddingPresenter(ScheduleView scheduleView, EventBus eventBus) {
		this.scheduleView = scheduleView;
		this.eventBus = eventBus;
	}
	
	public void setData() {
		int group = 0;
		try {
			group = Integer.parseInt( LocalStorageUtil.getCurrentSelectedGroup() );
		} catch (Exception e) {
			
			group = 1;
		}
		this.scheduleView.setSchedules(LoadsheddingDataConstructor.getSchedules(JSONExtractor.extractJSON()), group);
	}

	public Widget getView() {
		return this.scheduleView;
	}

	@Override
	public void onGroupChanged(GroupChangeEvent event) {
		this.scheduleView.setSchedules(LoadsheddingDataConstructor.getSchedules(), event.getGroup());
	}
	
}

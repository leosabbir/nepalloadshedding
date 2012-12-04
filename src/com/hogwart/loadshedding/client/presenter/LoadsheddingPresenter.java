package com.hogwart.loadshedding.client.presenter;

import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.hogwart.loadshedding.client.ds.LoadsheddingDataSource;
import com.hogwart.loadshedding.client.event.GroupChangeEvent;
import com.hogwart.loadshedding.client.model.ScheduleFromTo;
import com.hogwart.loadshedding.client.view.ScheduleView;

public class LoadsheddingPresenter implements GroupChangeEvent.Handler {

	ScheduleView scheduleView;
	List<List<ScheduleFromTo>> schedules;
	EventBus eventBus;
	
	
	public LoadsheddingPresenter(ScheduleView scheduleView, EventBus eventBus) {
		this.scheduleView = scheduleView;
		this.eventBus = eventBus;
	}
	
	public void setData() {
		schedules = LoadsheddingDataSource.getSchedules();
		this.scheduleView.setSchedules(schedules, 5);
	}

	public Widget getView() {
		return this.scheduleView;
	}

	@Override
	public void onGroupChanged(GroupChangeEvent event) {
		this.scheduleView.setSchedules(schedules, event.getGroup());
	}
	
}

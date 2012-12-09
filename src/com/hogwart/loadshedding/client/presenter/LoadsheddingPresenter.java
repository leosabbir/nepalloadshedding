package com.hogwart.loadshedding.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.hogwart.loadshedding.client.bind.ClientFactory;
import com.hogwart.loadshedding.client.constants.Constants;
import com.hogwart.loadshedding.client.ds.LoadsheddingDataConstructor;
import com.hogwart.loadshedding.client.event.DataReceivedEvent;
import com.hogwart.loadshedding.client.event.GroupChangeEvent;
import com.hogwart.loadshedding.client.util.DataExtractorUtil;
import com.hogwart.loadshedding.client.util.LocalStorageUtil;
import com.hogwart.loadshedding.client.view.ScheduleView;

public class LoadsheddingPresenter implements GroupChangeEvent.Handler, DataReceivedEvent.Handler {

	ScheduleView scheduleView;
	EventBus eventBus;
	
	int group;
	
	public LoadsheddingPresenter(ScheduleView scheduleView, EventBus eventBus) {
		this.scheduleView = scheduleView;
		this.eventBus = eventBus;
	}
	
	public void setData() {
		group = 0;
		try {
			group = Integer.parseInt( LocalStorageUtil.getCurrentSelectedGroup() );
		} catch (Exception e) {
			group = 1;
		}
		try {
			this.scheduleView.setSchedules(LoadsheddingDataConstructor.getSchedules(ClientFactory.getSchedule()), group);
		} catch (Exception e) {
			ClientFactory.Reset();
		}
	}

	public Widget getView() {
		return this.scheduleView;
	}

	@Override
	public void onGroupChanged(GroupChangeEvent event) {
		this.scheduleView.setSchedules(LoadsheddingDataConstructor.getSchedules(), event.getGroup());
	}

	@Override
	public void onDataReceived(DataReceivedEvent event) {
		String type = event.getRequestType();
		String data = event.getData();
		
		if ( type.equals(Constants.VER_TYPE)) {
			LocalStorageUtil.storeCurrentScheduleVersion(data);
			this.scheduleView.setTestLbl(data);
			this.scheduleView.showSchedulePanel(false);
			DataExtractorUtil.extract(Constants.SCHEDULE_URL, Constants.SCHE_TYPE);
		} else if ( type.equals(Constants.SCHE_TYPE)) {
			LocalStorageUtil.storeCurrentSchedule(data);
			try {
				this.scheduleView.setSchedules(LoadsheddingDataConstructor.getSchedules(ClientFactory.getSchedule()), group);
			} catch (Exception e) {
				ClientFactory.Reset();
			}
			this.scheduleView.showSchedulePanel(true);
		} else {
			//TODO show server not reachable
		}
		this.scheduleView.setTestLbl("received" + event.getData() + event.getData().length());
	}

}

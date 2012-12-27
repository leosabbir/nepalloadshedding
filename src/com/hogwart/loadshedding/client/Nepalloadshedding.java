package com.hogwart.loadshedding.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.hogwart.loadshedding.client.bind.ClientFactory;
import com.hogwart.loadshedding.client.ds.TestJSONMockedSchedule;
import com.hogwart.loadshedding.client.event.DataReceivedEvent;
import com.hogwart.loadshedding.client.event.GroupChangeEvent;
import com.hogwart.loadshedding.client.presenter.LoadsheddingPresenter;
import com.hogwart.loadshedding.client.resources.LoadsheddingResources;
import com.hogwart.loadshedding.client.util.DataExtractorUtil;
import com.hogwart.loadshedding.client.util.LocalStorageUtil;
import com.hogwart.loadshedding.client.view.ScheduleView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Nepalloadshedding implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		EventBus eventBus = ClientFactory.getEventBus();
		LoadsheddingResources.INSTANCE.loadsheddingCss().ensureInjected();
		LoadsheddingResources.INSTANCE.loadsheddingButtonCss().ensureInjected();
		LoadsheddingResources.INSTANCE.globalCss().ensureInjected();
		
		this.loadLocalStorageData();

		DataExtractorUtil.getScheduleVersion();
		
		final ScheduleView view = new ScheduleView();
		LoadsheddingPresenter presenter = new LoadsheddingPresenter(view, eventBus);
		
		eventBus.addHandler(GroupChangeEvent.TYPE, presenter);
		eventBus.addHandler(DataReceivedEvent.TYPE, presenter);
		
		presenter.setData();
		
		RootPanel.get("gwt").add(presenter.getView());

	}
	
	private void loadLocalStorageData () {
		String version = LocalStorageUtil.getCurrentScheduleVersion();
		String schedule = LocalStorageUtil.getCurrentSchedule();
		
		if( version == null || schedule == null) {
			version = TestJSONMockedSchedule.VERSION;
			schedule = TestJSONMockedSchedule.SCHEDULE;
			
			LocalStorageUtil.storeCurrentSchedule(schedule);
			LocalStorageUtil.storeCurrentScheduleVersion(version);

		}
		
		try {
			ClientFactory.setScheduleVersion(version);
		} catch (Exception e) {
			ClientFactory.Reset();
		}
		ClientFactory.setSchedule(schedule);
	}
}

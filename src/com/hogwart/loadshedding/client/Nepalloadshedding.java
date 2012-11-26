package com.hogwart.loadshedding.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.hogwart.loadshedding.client.ds.LoadsheddingDataSource;
import com.hogwart.loadshedding.client.model.ScheduleLength;
import com.hogwart.loadshedding.client.resources.LoadsheddingResources;
import com.hogwart.loadshedding.client.view.ScheduleView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Nepalloadshedding implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		LoadsheddingResources.INSTANCE.loadsheddingCss().ensureInjected();
		LoadsheddingResources.INSTANCE.loadsheddingButtonCss().ensureInjected();
		LoadsheddingResources.INSTANCE.globalCss().ensureInjected();
		
		final ScheduleView view = new ScheduleView();
		
		List<List<ScheduleLength>> schedules = LoadsheddingDataSource.getMockedData();
		view.setSchedules(schedules);
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("gwt").add(view);

		// Focus the cursor on the name field when the app loads
	}
}

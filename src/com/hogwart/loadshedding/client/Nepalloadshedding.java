package com.hogwart.loadshedding.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.hogwart.loadshedding.client.bind.ClientFactory;
import com.hogwart.loadshedding.client.ds.LoadsheddingDataSource;
import com.hogwart.loadshedding.client.event.GroupChangeEvent;
import com.hogwart.loadshedding.client.model.ScheduleFromTo;
import com.hogwart.loadshedding.client.presenter.LoadsheddingPresenter;
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
		
		EventBus eventBus = ClientFactory.getEventBus();
		LoadsheddingResources.INSTANCE.loadsheddingCss().ensureInjected();
		LoadsheddingResources.INSTANCE.loadsheddingButtonCss().ensureInjected();
		LoadsheddingResources.INSTANCE.globalCss().ensureInjected();
		
		final ScheduleView view = new ScheduleView();
		LoadsheddingPresenter presenter = new LoadsheddingPresenter(view, eventBus);
		
		eventBus.addHandler(GroupChangeEvent.TYPE, presenter);
		
		presenter.setData();
		
		RootPanel.get("gwt").add(presenter.getView());

	}
}

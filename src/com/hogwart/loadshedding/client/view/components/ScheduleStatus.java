package com.hogwart.loadshedding.client.view.components;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.hogwart.loadshedding.client.ui.ServerConnectionIndicator;

public class ScheduleStatus extends Composite {

	private static ScheduleStatusUiBinder uiBinder = GWT.create(ScheduleStatusUiBinder.class);

	interface ScheduleStatusUiBinder extends UiBinder<Widget, ScheduleStatus> {
	}

	public ScheduleStatus() {
		initWidget(uiBinder.createAndBindUi(this));
		
		serverconnection.addStyleDependentName("connected");
		serverconnection.setTitleText("Schedule is Updated!!!");
		connectionStatus.setText("schedule updated");
	}
	
	@UiField
	ServerConnectionIndicator serverconnection;
	
	@UiField
	Label infoLbl;
	
	@UiField
	Label connectionStatus;
	
	public void setEffectiveFrom(String effectiveFrom ) {
		this.infoLbl.setText("Effective from: " + effectiveFrom);
	}
	
	public void showUpdating() {
		serverconnection.removeStyleDependentName("connected");
		serverconnection.removeStyleDependentName("notconnected");
		serverconnection.addStyleDependentName("connected");
		connectionStatus.setText("updating schedule..");
		serverconnection.setTitleText("Schedule is Updated!!!");
	}
	
	public void setConnectionIndicator(boolean connected) {
		if(connected) {
			serverconnection.removeStyleDependentName("notconnected");
			serverconnection.addStyleDependentName("connected");
			serverconnection.setTitleText("Schedule is Updated!!!");

			connectionStatus.setText("schedule updated");
		} else {
			serverconnection.removeStyleDependentName("connected");
			serverconnection.addStyleDependentName("notconnected");
			serverconnection.setTitleText("Could not connect to server to update schedule!!!");

			connectionStatus.setText("No connection for update");
		}
		serverconnection.setFocus(false);
	}

}

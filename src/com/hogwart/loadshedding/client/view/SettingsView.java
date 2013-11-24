package com.hogwart.loadshedding.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SettingsView extends Composite {

	private static SettingsViewUiBinder uiBinder = GWT.create(SettingsViewUiBinder.class);

	interface SettingsViewUiBinder extends UiBinder<Widget, SettingsView> {
	}

	public SettingsView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	CheckBox enableNotification;
	
	@UiField
	TextBox notificationTime;
	
	@UiField
	Button confirm;
	
	@UiField
	Label errorLbl;

	public SettingsView(boolean enableNotification, int notificationTime) {
		initWidget(uiBinder.createAndBindUi(this));
		this.enableNotification.setEnabled(enableNotification);
		if (notificationTime >= 0) {
			this.notificationTime.setText(notificationTime + "");
		}
	}

	@UiHandler("enableNotification")
	void onEnableNotificationClick(ClickEvent e) {
		//TODO save in local storage
		
	}
	
	@UiHandler("enableNotification")
	void onTimeConfirm(ClickEvent e) {
		int notificationTime;
		try {
			notificationTime = Integer.parseInt(this.notificationTime.getText());
		} catch (NumberFormatException excptn) {
			this.errorLbl.setText("Please enter valid notification time");
		}
		//TODO store notification time in local storage
	}
	
	@UiHandler("notificationTime")
	void onTimeChange(ChangeEvent e) {
		this.errorLbl.setVisible(false);
		
	}
}

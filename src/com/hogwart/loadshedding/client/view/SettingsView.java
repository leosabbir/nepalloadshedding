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
import com.hogwart.loadshedding.client.bind.ClientFactory;
import com.hogwart.loadshedding.client.util.LocalStorageUtil;

public class SettingsView extends Composite {

	private static SettingsViewUiBinder uiBinder = GWT.create(SettingsViewUiBinder.class);

	interface SettingsViewUiBinder extends UiBinder<Widget, SettingsView> {
	}

	@UiField
	CheckBox enableNotification;
	
	@UiField
	TextBox notificationTime;
	
	@UiField
	Button confirm;
	
	@UiField
	Label errorLbl;

	public SettingsView() {
		boolean enableNotification = ClientFactory.isNotificationEnabled();
		int notificationTime = ClientFactory.getNotificationTime();
		initWidget(uiBinder.createAndBindUi(this));
		this.enableNotification.setValue(enableNotification);
		if (notificationTime >= 0) {
			this.notificationTime.setText(notificationTime + "");
		} else {
			this.notificationTime.setText("10");
		}
		this.notificationTime.setEnabled(enableNotification);
	}

	@UiHandler("enableNotification")
	void onEnableNotificationClick(ClickEvent e) {
		this.notificationTime.setEnabled(this.enableNotification.getValue());
		//this.errorLbl.setVisible(true);
		this.errorLbl.setStyleName("savedLabel");
		//this.errorLbl.setText("Settings Changed");
	}
	
	@UiHandler("notificationTime")
	void onValueChange(ChangeEvent e) {
		//this.errorLbl.setVisible(true);
		this.errorLbl.setStyleName("savedLabel");
		//this.errorLbl.setText("Settings Changed");
	}
	
	@UiHandler("confirm")
	void onTimeConfirm(ClickEvent e) {
		int notificationTime;
		this.errorLbl.setVisible(true);
		this.errorLbl.setStyleName("savedLabel");
		this.errorLbl.setText("Saving.....");
		try {
			notificationTime = Integer.parseInt(this.notificationTime.getText());
			if (notificationTime >=0 && notificationTime <= 60) {
				LocalStorageUtil.storeNotificationEnabled(this.enableNotification.getValue());
				LocalStorageUtil.storeNotificationTime(notificationTime);
				LocalStorageUtil.storeNotificationChanged(true);
				this.errorLbl.setText("Saved");
				this.errorLbl.setVisible(true);
				this.errorLbl.setStyleName("savedLabel");
			} else {
				throw new Exception();
			}
		} catch (Exception excptn) {
			this.errorLbl.setText("Please enter valid notification time");
			this.errorLbl.setVisible(true);
			this.errorLbl.setStyleName("errorLabel");
		}
	}
	
	public void hideSaveResult() {
		this.errorLbl.setVisible(false);
	}
	
}

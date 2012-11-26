package com.hogwart.loadshedding.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hogwart.loadshedding.client.model.ScheduleLength;
import com.hogwart.loadshedding.client.view.components.ScheduleComponent;

public class ScheduleView extends Composite {

	private static ScheduleViewUiBinder uiBinder = GWT
			.create(ScheduleViewUiBinder.class);

	interface ScheduleViewUiBinder extends UiBinder<Widget, ScheduleView> {
	}

	public ScheduleView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button group1Btn;
	
	@UiField
	Button group2Btn;
	
	@UiField
	Button group3Btn;
	
	@UiField
	Button group4Btn;
	
	@UiField
	Button group5Btn;
	
	@UiField
	Button group6Btn;
	
	@UiField
	Button group7Btn;
	
	@UiField
	ScheduleComponent sunSchedule;
	
	@UiField
	ScheduleComponent monSchedule;
	
	@UiField
	ScheduleComponent tueSchedule;
	
	@UiField
	ScheduleComponent wedSchedule;
	
	@UiField
	ScheduleComponent thuSchedule;
	
	@UiField
	ScheduleComponent friSchedule;
	
	@UiField
	ScheduleComponent satSchedule;


	@UiHandler("group1Btn")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}
	
	public void setSchedules(List<List<ScheduleLength>> schedules) {
		for (int i = 0; i < schedules.size(); i++) {
			if( i == 0) {
				this.sunSchedule.setScheduleTimes(schedules.get(i));
			} else if( i == 1) {
				this.monSchedule.setScheduleTimes(schedules.get(i));
			}else if( i == 2) {
				this.tueSchedule.setScheduleTimes(schedules.get(i));
			}else if( i == 3) {
				this.wedSchedule.setScheduleTimes(schedules.get(i));
			}else if( i == 4) {
				this.thuSchedule.setScheduleTimes(schedules.get(i));
			}else if( i == 5) {
				this.friSchedule.setScheduleTimes(schedules.get(i));
			}else {
				this.satSchedule.setScheduleTimes(schedules.get(i));
			}
		}
	}

}

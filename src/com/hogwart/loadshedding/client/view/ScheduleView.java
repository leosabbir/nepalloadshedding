package com.hogwart.loadshedding.client.view;

import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hogwart.loadshedding.client.event.GroupChangeEvent;
import com.hogwart.loadshedding.client.model.LoadsheddingStatus;
import com.hogwart.loadshedding.client.model.ScheduleFromTo;
import com.hogwart.loadshedding.client.util.Utils;
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


	@UiHandler({"group1Btn", "group2Btn", "group3Btn", "group4Btn", "group5Btn", "group6Btn", "group7Btn"})
	void onClick(ClickEvent e) {
		fireEvent(new GroupChangeEvent(0));
		//Window.alert("Hello!" + ((Button)e.getSource()).getText());
	}
	
	@SuppressWarnings("deprecation")
	public void setSchedules(List<List<ScheduleFromTo>> schedules, int group) {
		Date date = new Date();
		int day = date.getDay();
		int hour = date.getHours();
		int minute = date.getMinutes();
		
		int sunScheduleIndex = group == 1 ? 0 : 8 - group;
		LoadsheddingStatus status = Utils.getLoadsheddingStatus(schedules.get((sunScheduleIndex + day) % 7), hour, minute, day, sunScheduleIndex);
		
		for (int i = 0; i < schedules.size(); i++) {
			if( i == 0) {
				this.setScheduleAndStatus(this.sunSchedule, schedules.get((sunScheduleIndex + i) % 7), status, i == day);
			} else if( i == 1) {
				this.setScheduleAndStatus(this.monSchedule, schedules.get((sunScheduleIndex + i) % 7), status, i == day);
			}else if( i == 2) {
				this.setScheduleAndStatus(this.tueSchedule, schedules.get((sunScheduleIndex + i) % 7), status, i == day);
			}else if( i == 3) {
				this.setScheduleAndStatus(this.wedSchedule, schedules.get((sunScheduleIndex + i) % 7), status, i == day);
			}else if( i == 4) {
				this.setScheduleAndStatus(this.thuSchedule, schedules.get((sunScheduleIndex + i) % 7), status, i == day);
			}else if( i == 5) {
				this.setScheduleAndStatus(this.friSchedule, schedules.get((sunScheduleIndex + i) % 7), status, i == day);
			}else {
				this.setScheduleAndStatus(this.satSchedule, schedules.get((sunScheduleIndex + i) % 7), status, i == day);
			}
		}
	}
	
	private void setScheduleAndStatus(ScheduleComponent scheduleComponent, List<ScheduleFromTo> schedules, LoadsheddingStatus status, boolean today) {
		if ( today ) {
			scheduleComponent.setStatus(status);
			scheduleComponent.addStyleDependentName("selected");
		}
		scheduleComponent.setScheduleTimes(schedules);
	}
}

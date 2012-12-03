package com.hogwart.loadshedding.client.view.components;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.hogwart.loadshedding.client.model.LoadsheddingStatus;
import com.hogwart.loadshedding.client.model.ScheduleFromTo;
import com.hogwart.loadshedding.client.ui.LoadsheddingIndicator;

public class ScheduleComponent extends Composite {

	private static ScheduleComponentUiBinder uiBinder = GWT
			.create(ScheduleComponentUiBinder.class);

	interface ScheduleComponentUiBinder extends
			UiBinder<Widget, ScheduleComponent> {
	}

	public ScheduleComponent() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Label dayField;
	
	@UiField
	FlowPanel timeField;
	
	@UiField
	FlowPanel indicatorContainer;
	
	public void setDay(String day) {
		this.dayField.setText(day);
		
		//indicatorContainer.add(new LoadsheddingIndicator("test", "on"));
	}
	
	public void setScheduleTimes(List<ScheduleFromTo> scheduleTimes) {
		for (ScheduleFromTo time : scheduleTimes) {
			Label timeLbl = new Label(time.toString());
			this.timeField.add(timeLbl);
		}
	}

	public void setStatus(LoadsheddingStatus status) {
		indicatorContainer.add(new LoadsheddingIndicator(status.getHourRemaining() + " : " + status.getMinuteRemaining(), status.getOnOff() == 0 ? "off" : "on"));
	}
	
	

}

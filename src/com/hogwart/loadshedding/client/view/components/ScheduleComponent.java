package com.hogwart.loadshedding.client.view.components;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
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
	}
	
	public void setScheduleTimes(List<ScheduleFromTo> scheduleTimes) {
		this.timeField.clear();
		if (scheduleTimes.size() > 0) {
			for (ScheduleFromTo time : scheduleTimes) {
				HTML timeLbl = new HTML(time.toString());
				this.timeField.add(timeLbl);
			}
		} else {
			HTML timeLbl = new HTML("No Loadshedding!!");
			this.timeField.add(timeLbl);
		}
		
	}

	public void setStatus(LoadsheddingStatus status) {
		indicatorContainer.clear();
		LoadsheddingIndicator indicator = new LoadsheddingIndicator(status.getTime(), status.getOnOff() == 0 ? "off" : "on");
		if( status.getOnOff() == 0 ) {
			indicator.setTitle("Light will come after " + status.getHourRemaining() + " hours " + status.getMinuteRemaining() + "minutes.");
		} else {
			indicator.setTitle("Light will remain for " + status.getHourRemaining() + " hours " + status.getMinuteRemaining() + "minutes.");
		}
		indicatorContainer.add(indicator);
	}
	
	public void setNoLoadsheddingStatus() {
		indicatorContainer.clear();
		LoadsheddingIndicator indicator = new LoadsheddingIndicator(":-)", "on");
		indicator.setTitle("BINGO!!! No Loadshedding :)");
		indicatorContainer.add(indicator);
	}
}

package com.hogwart.loadshedding.client.ui;

public class ServerConnectionIndicator extends DescriptiveImageLabel {

	public ServerConnectionIndicator() {
		super("");
		setStylePrimaryName("serverconnection");
	}
	
	public void setTitleText(String text) {
		this.setTitle(text);
	}

}

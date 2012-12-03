package com.hogwart.loadshedding.client.ui;

public class LoadsheddingIndicator extends DescriptiveImageLabel {

	public LoadsheddingIndicator(String text, String styleSuffix) {
		super(text);
		addStyleDependentName(styleSuffix);
	}

}

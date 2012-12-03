package com.hogwart.loadshedding.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.Button;

public class DescriptiveImageLabel extends Button {
	public static final String STYLE_PRIMARY_NAME = "loadshedding-bulb";
	private static final MyTemplate TEMPLATE = GWT.create(MyTemplate.class);

	private String text;

	public DescriptiveImageLabel(String text) {
		setStylePrimaryName(STYLE_PRIMARY_NAME);
		this.text = text;
		updateHTML();
	}

	// --------------------- Interface HasText ---------------------

	@Override
	public void setText(final String text) {
		this.text = text;
		updateHTML();
	}

	private void updateHTML() {
		setTitle(text);
		
		setHTML(TEMPLATE.text(text != null ? text : ""));
	}

	public interface MyTemplate extends SafeHtmlTemplates {
		@Template("<div class=\"icon\"></div><div class=\"text\">{0}</div>")
		SafeHtml text(String text);
	}
}


package com.hogwart.loadshedding.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface LoadsheddingResources extends ClientBundle {

	public static final LoadsheddingResources INSTANCE = GWT.create(LoadsheddingResources.class);

	@Source("loadshedding.css")
	LoadsheddingCssResource loadsheddingCss();
	
//	@NotStrict
//	@Source("dialoguebox.css")
//	CssResource esewaBankDialogueBoxCss();
	
//	@NotStrict
//	@Source("datebox.css")
//	CssResource esewaBankDateBoxCss();
	
	@NotStrict
	@Source("button.css")
	CssResource loadsheddingButtonCss();
	
	@NotStrict
	@Source("global.css")
	CssResource globalCss();
	
	@Source("bulb_32.png")
	ImageResource bulbOff();
	
	@Source("bulb_off_32.png")
	ImageResource bulbOn();
//	
//	@Source("images/delete.png")
//	ImageResource iconDelete();
//	
//	@Source("images/delete.png")
//	ImageResource iconDetails();
//	
//	@Source("images/logoff_red.png")
//	ImageResource iconLogoff();
//	
//	@Source("images/close_16x16.png")
//	ImageResource closeIcon();
//	
//	@Source("images/view_details.png")
//	ImageResource viewDetailsIcon();

}

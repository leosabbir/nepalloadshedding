package com.hogwart.loadshedding.client.resources;

import com.google.gwt.user.cellview.client.CellTable.Resources;
import com.google.gwt.user.cellview.client.CellTable.Style;

public interface CellTableResources extends Resources {

	@Override
	@Source("celltable.css")
	Style cellTableStyle();

}

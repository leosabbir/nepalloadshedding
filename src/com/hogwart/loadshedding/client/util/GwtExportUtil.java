package com.hogwart.loadshedding.client.util;

public class GwtExportUtil {
	
	public native void expose()/*-{
    		$wnd.exposedMethod = function(param) {
         		@com.hogwart.loadshedding.client.util.Utils::getLoadsheddingStatus(*)(param);
    		}
	
	}-*/;

}

package com.hogwart.loadshedding.client.util;

import com.google.gwt.i18n.client.NumberFormat;

public class NumberFormatUtil {

	public static String formatNumber ( int num ) {
		NumberFormat format = NumberFormat.getFormat("00");
		return format.format(num);
	}
}

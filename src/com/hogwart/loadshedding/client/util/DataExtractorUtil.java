package com.hogwart.loadshedding.client.util;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.hogwart.loadshedding.client.bind.ClientFactory;
import com.hogwart.loadshedding.client.constants.Constants;
import com.hogwart.loadshedding.client.event.DataReceivedEvent;

public class DataExtractorUtil {

	public static void getScheduleVersion() {
		extract(Constants.SCHEDULE_VERSION_URL, Constants.VER_TYPE);
	}

	public static void extract(String url, final String requestType) {

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(url));
		try {
			builder.sendRequest(null, new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					if (response.getStatusCode() == 200) {
						if (requestType.equals(Constants.VER_TYPE)) {
							String version = response.getText();
							if (!version.equals(ClientFactory.getScheduleVersion())) {
								//ClientFactory.setScheduleVersion(version);
								ClientFactory.getEventBus().fireEvent(new DataReceivedEvent(version, requestType));
								//extract(Constants.SCHEDULE_URL, Constants.SCHE_TYPE);
							}
						} else {
							String schedule = response.getText();
							ClientFactory.getEventBus().fireEvent(new DataReceivedEvent(schedule, requestType));
						}
					} else {
						ClientFactory.getEventBus().fireEvent(new DataReceivedEvent("asfas", ""));
					}

				}

				@Override
				public void onError(Request request, Throwable exception) {
					//ClientFactory.getEventBus().fireEvent(new DataReceivedEvent("", ""));
				}
			});
		} catch (RequestException e) {
			//ClientFactory.getEventBus().fireEvent(new DataReceivedEvent("", ""));
		}
	}
}

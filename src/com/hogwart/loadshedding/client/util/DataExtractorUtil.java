package com.hogwart.loadshedding.client.util;

import java.util.LinkedList;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.hogwart.loadshedding.client.bind.ClientFactory;
import com.hogwart.loadshedding.client.event.DataReceivedEvent;

public class DataExtractorUtil {
	
	private static String response;
	

	public static native String get() /*-{
		var xhr = new XMLHttpRequest();
		xhr.open("GET", "http://api.geonames.org/astergdemJSON?formatted=true&lat=50.01&lng=10.2&username=demo&style=full", true);

		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				//response = xhr.responseText;
				return "now this is very confusing";
			} else {
				return "voldemort";
			}
			return "return of the king";
		}
		xhr.send();
		//response = "hurcruxes";

	}-*/;
	
	public static void test() {
		
	
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode("http://api.geonames.org/astergdemJSON?formatted=true&lat=50.01&lng=10.2&username=demo&style=full"));
	//RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode("http://localhost:8888"));
	try {
		builder.sendRequest(null, new RequestCallback() {
			@Override
			public void onResponseReceived(Request request,Response response) {
				ClientFactory.getEventBus().fireEvent(new DataReceivedEvent("Response:" + response.getStatusCode() + response.getText()));
//				if (200 == response.getStatusCode()) {
//					String responseXMLText		= response.getText() ;
//					photos	= getPhotos(responseXMLText) ;
//				}
			}
			@Override
			public void onError(Request request, Throwable exception) {
				Window.alert("Exception: " + exception.toString());
			}
		}) ;
	} catch (RequestException e) {
		// TODO - Give the user an appropriate message something bad happened.
		//System.out.println(e) ;
	}
	}
}

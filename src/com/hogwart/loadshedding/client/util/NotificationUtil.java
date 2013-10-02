package com.hogwart.loadshedding.client.util;

public class NotificationUtil {
	
	public static native void createNotification (int onOff, int timeRemaining) /*-{
		var notification = webkitNotifications.createNotification (
		  	'icons/bulbOn.png',  // icon url - can be relative
		  	'Hello!',  // notification title
		  	localStorage.nepalLoadsheddingSchedule  // notification body text
		);
		
		setToHappen = function(fn, date) {
			//fn;
  			//var now = new Date().getTime();
  			//var diff = date.getTime() - now;
  			//var milliseconds = diff * 1000;
  			return setInterval(fn, 3000);
 		}
 		
 		showNotification = function() {
 			notification.show()
 		}
		
		setToHappen(showNotification, new Date());
		
		// Or create an HTML notification:
		//var notification = webkitNotifications.createHTMLNotification(
		//  'notification.html'  // html url - can be relative
		//);
		
		// Then show the notification.
		//notification.show();
	}-*/;

}

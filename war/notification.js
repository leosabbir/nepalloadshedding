var notification = webkitNotifications.createNotification('icons/bulbOn.png', // icon url - can be relative
'Hello!', // notification title
localStorage.nepalLoadsheddingSchedule // notification body text
);
//notification.show();

chrome.extension.onRequest.addListener(function(request, sender, sendResponse) {
    // Create a simple text notification
    var notify = webkitNotifications.createNotification('icons/bulbOn.png', 'Notification', 'Fuck it works :D');
    notify.show();
    setTimeout(function(){ notify.cancel(); },3000);
});

chrome.extension.sendRequest({
	  message: "There is a video"},  // Change the message here as needed.
	  function(response) {
	  return response;
	});

setToHappen = function(fn, date) {
	//fn;
	//var now = new Date().getTime();
	//var diff = date.getTime() - now;
	//var milliseconds = diff * 1000;
	return setInterval(fn, 3000);
}

showNotification = function() {
	notification.show();
}
setToHappen(showNotification, new Date());

callbk = function(id) {
	notification.show();
	setInterval(callbk, 3000);
}

var opt = {
		  type: "list",
		  title: "Primary Title",
		  message: "Primary message to display",
		  iconUrl: "icons/bulbOn.png",
		  items: [{ title: "Item1", message: "This is item 1."},
		          { title: "Item2", message: "This is item 2."},
		          { title: "Item3", message: "This is item 3."}]
		}

chrome.notifications.create("newnoti", opt, callbk)
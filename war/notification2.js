alert("background page loaded");
function show() {
	var notification = webkitNotifications.createNotification('icons/bulbOn.png', // icon url - can be relative
			'!!! LOADSHEDDING ALERT !!!', // notification title
			localStorage.nepalLoadsheddingSchedule // notification body text
			);
	notification.show();
}

var interval = 1000 * 60 * 60;
if (webkitNotifications) {
	setInterval(show, interval);
}

//TODO
// Selected Group is localStorage.nepalLoadsheddingGroup
// 
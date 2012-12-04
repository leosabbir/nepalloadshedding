package com.hogwart.loadshedding.client.ds;

import java.util.ArrayList;
import java.util.List;

import com.hogwart.loadshedding.client.model.ScheduleFromTo;
import com.hogwart.loadshedding.client.model.Time;

public class LoadsheddingDataSource {

	private static List<List<ScheduleFromTo>> schedules;
	
	public static List<List<ScheduleFromTo>> getSchedules () {
		if ( schedules == null ) {
			getMockedData();
		}
		return schedules;
	}

	public static void getMockedData() {
		schedules = new ArrayList<List<ScheduleFromTo>>();
		// Sunday
		List<ScheduleFromTo> singleDaySchedule = new ArrayList<ScheduleFromTo>();
		ScheduleFromTo scheduleLength = new ScheduleFromTo(new Time(5, 0),
				new Time(9, 0));
		singleDaySchedule.add(scheduleLength);

		scheduleLength = new ScheduleFromTo(new Time(13, 00), new Time(17, 0));
		singleDaySchedule.add(scheduleLength);

		schedules.add(singleDaySchedule);

		// Monday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(12, 0), new Time(16, 30));
		singleDaySchedule.add(scheduleLength);
		scheduleLength = new ScheduleFromTo(new Time(19, 30), new Time(23, 00));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);

		// Tuesday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(11, 00), new Time(15, 00));
		singleDaySchedule.add(scheduleLength);
		scheduleLength = new ScheduleFromTo(new Time(19, 0), new Time(22, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);

		// Wednesday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(9, 0), new Time(13, 0));
		singleDaySchedule.add(scheduleLength);

		scheduleLength = new ScheduleFromTo(new Time(17, 0), new Time(21, 0));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);

		// Thursday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(7, 30), new Time(12, 0));
		singleDaySchedule.add(scheduleLength);
		scheduleLength = new ScheduleFromTo(new Time(17, 0), new Time(20, 30));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);

		// Friday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(6, 0), new Time(11, 0));
		singleDaySchedule.add(scheduleLength);
		scheduleLength = new ScheduleFromTo(new Time(16, 30), new Time(19, 30));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);

		// Saturday
		singleDaySchedule = new ArrayList<ScheduleFromTo>();
		scheduleLength = new ScheduleFromTo(new Time(5, 0), new Time(10, 0));
		singleDaySchedule.add(scheduleLength);
		scheduleLength = new ScheduleFromTo(new Time(15, 0), new Time(19, 00));
		singleDaySchedule.add(scheduleLength);
		schedules.add(singleDaySchedule);
	}

	@Deprecated
	public static void setData(List<List<ScheduleFromTo>> schedules) {
		LoadsheddingDataSource.schedules = schedules;
	}

	public static Time getRemainingTime(int today, int sunScheduleIndex) {
		Time time = new Time(0, 0);

		for (int i = 1; i < 7; i++) {
			List<ScheduleFromTo> daySchedules = schedules.get((sunScheduleIndex + today + i) % 7);
			if (daySchedules.size() > 0) {
				time.setHour(time.getHour()
						+ daySchedules.get(0).getFromTime().getHour());
				time.setMinute(time.getMinute()
						+ daySchedules.get(0).getFromTime().getMinute());
				break;
			} else {
				time.setHour(time.getHour() + 24);

			}
		}

		return time;
	}

}

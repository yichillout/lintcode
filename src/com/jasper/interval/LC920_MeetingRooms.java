package com.jasper.interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC920_MeetingRooms {

	public boolean canAttendMeetings(List<Interval> intervals) {

		if (intervals == null || intervals.size() == 0)
			return true;

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});

		Interval prev = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			if (prev.end > intervals.get(i).start) {
				return false;
			}
			prev = intervals.get(i);
		}

		return true;
	}
}
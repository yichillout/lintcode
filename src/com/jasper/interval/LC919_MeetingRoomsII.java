package com.jasper.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC919_MeetingRoomsII {

	// Solution 1 : sweep line
	class Point {
		int time;
		int flag;

		Point(int t, int s) {
			this.time = t;
			this.flag = s;
		}
	}

	public int minMeetingRooms(List<Interval> intervals) {
		List<Point> list = new ArrayList<>(intervals.size() * 2);
		for (Interval interval : intervals) {
			list.add(new Point(interval.start, 1));
			list.add(new Point(interval.end, 0));
		}

		Collections.sort(list, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if (p1.time == p2.time) {
					return p1.flag - p2.flag;
				} else {
					return p1.time - p2.time;
				}
			}
		});

		int count = 0, ans = 0;

		for (Point p : list) {
			if (p.flag == 1) {
				count++;
			} else {
				count--;
			}
			ans = Math.max(ans, count);
		}

		return ans;
	}

	// Solution 2 : PriorityQueue
	public int minMeetingRooms2(List<Interval> intervals) {

		if (intervals.size() <= 1) {
			return intervals.size();
		}

		PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
			public int compare(Interval interval1, Interval interval2) {
				return interval1.end - interval2.end;
			}
		});

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});

		pq.add(intervals.get(0));

		for (int i = 1; i < intervals.size(); i++) {
			Interval tmp = pq.poll();
			if (tmp.end > intervals.get(i).start) {
				pq.add(intervals.get(i));
			} else {
				tmp.end = intervals.get(i).end;
			}
			pq.add(tmp);
		}

		return pq.size();
	}
}

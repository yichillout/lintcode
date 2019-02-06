package com.jasper.sweepline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Point {
	int time;
	int flag;

	Point(int t, int s) {
		this.time = t;
		this.flag = s;
	}

	public static Comparator<Point> PointComparator = new Comparator<Point>() {
		public int compare(Point p1, Point p2) {
			if (p1.time == p2.time)
				return p1.flag - p2.flag;
			else
				return p1.time - p2.time;
		}
	};
}

class Interval {
	int start, end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

/*
 * Input: [(1, 10), (2, 3), (5, 8), (4, 7)] 
 * Output: 3 Explanation: 
 * The first airplane takes off at 1 and lands at 10. 
 * The second ariplane takes off at 2 and lands at 3. 
 * The third ariplane takes off at 5 and lands at 8. 
 * The forth ariplane takes off at 4 and lands at 7. 
 * During 5 to 6, there are three airplanes in the sky.
 */

class Solution {

	public int countOfAirplanes(List<Interval> airplanes) {
		List<Point> list = new ArrayList<>(airplanes.size() * 2);
		for (Interval i : airplanes) {
			list.add(new Point(i.start, 1));
			list.add(new Point(i.end, 0));
		}

		Collections.sort(list, Point.PointComparator);
		int count = 0, ans = 1;
		for (Point p : list) {
			if (p.flag == 1)
				count++;
			else
				count--;
			ans = Math.max(ans, count);
		}

		return ans;
	}

}

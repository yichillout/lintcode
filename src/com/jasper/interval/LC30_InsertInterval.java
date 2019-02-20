package com.jasper.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC30_InsertInterval {

	// Solution 1
	public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {

		if (newInterval == null || intervals == null) {
			return intervals;
		}

		List<Interval> result = new ArrayList<>();

		int index = 0;

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
				index++;
			} else if (interval.start > newInterval.end) {
				result.add(interval);
			} else { // overlapping
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}

		result.add(index, newInterval);

		return result;
	}

	// Solution 2
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new ArrayList<>();

		if (intervals == null || intervals.size() == 0) {
			result.add(newInterval);
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});

		int index = 0;
		while (index < intervals.size() && intervals.get(index).start < newInterval.start) {
			index++;
		}

		intervals.add(index, newInterval);

		Interval prev = null;

		for (Interval interval : intervals) {
			if (prev == null || prev.end < interval.start) {
				result.add(interval);
				prev = interval;
			} else {
				prev.end = Math.max(interval.end, prev.end);
			}
		}

		return result;
	}

}

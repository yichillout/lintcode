package com.jasper.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC156_MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> result = new ArrayList<>();

		if (intervals == null || intervals.size() == 0)
			return result;

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});

		Interval prev = null;

		for (Interval interval : intervals) {
			if (prev == null || prev.end < interval.start) {
				result.add(interval);
				prev = interval;
			} else {
				prev.end = Math.max(prev.end, interval.end);
			}
		}

		return result;
	}

}

package com.jasper.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC156_MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> results = new ArrayList<>();

		Collections.sort(intervals, (x, y) -> x.start - y.start);

		Interval pre = null;

		for (Interval interval : intervals) {
			if (pre == null || pre.end < interval.start) {
				results.add(interval);
				pre = interval;
			} else {
				pre.end = Math.max(pre.end, interval.end);
			}
		}

		return results;
	}
}

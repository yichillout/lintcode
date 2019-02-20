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

		Interval prev = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			if (prev.end >= intervals.get(i).start) {
				prev.end = Math.max(prev.end, intervals.get(i).end);
			} else {
				result.add(prev);
				prev = intervals.get(i);
			}
		}

		result.add(prev);

		return result;
	}

}

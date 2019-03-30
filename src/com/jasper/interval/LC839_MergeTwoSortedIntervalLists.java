package com.jasper.interval;

import java.util.ArrayList;
import java.util.List;

public class LC839_MergeTwoSortedIntervalLists {

	public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {

		List<Interval> results = new ArrayList<>();

		if (list1 == null || list1.size() == 0 || list2 == null || list2.size() == 0)
			return results;

		int i = 0;
		int j = 0;

		Interval prev = null;
		Interval cur = null;

		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i).start < list2.get(j).start) {
				cur = list1.get(i);
				i++;
			} else {
				cur = list2.get(j);
				j++;
			}
			prev = mergeInterval(results, prev, cur);
		}

		while (i < list1.size()) {
			prev = mergeInterval(results, prev, list1.get(i));
			i++;
		}

		while (j < list2.size()) {
			prev = mergeInterval(results, prev, list2.get(j));
			j++;
		}

		results.add(prev);

		return results;
	}

	private Interval mergeInterval(List<Interval> results, Interval prev, Interval cur) {
		if (prev == null)
			return cur;

		if (prev.end < cur.start) {
			results.add(prev);
			return cur;
		}

		prev.end = Math.max(prev.end, cur.end);
		return prev;
	}
}

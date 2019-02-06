package com.jasper.sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class LC131_TheSkylineProblem {

	public List<List<Integer>> buildingOutline(int[][] buildings) {

		List<List<Integer>> res = new ArrayList<>();
		if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
			return res;
		}
		List<int[]> points = new ArrayList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		map.put(0, 1);
		for (int[] building : buildings) {
			points.add(new int[] { building[0], -building[2] });
			points.add(new int[] { building[1], building[2] });
		}

		Collections.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
			}
		});

		int prev = 0;
		int start = points.get(0)[0];
		for (int[] point : points) {
			if (point[1] < 0) {
				map.put(-point[1], map.getOrDefault(-point[1], 0) + 1);
			} else {
				int cnt = map.get(point[1]);
				if (cnt == 1) {
					map.remove(point[1]);
				} else {
					map.put(point[1], cnt - 1);
				}
			}
			int cur = map.firstKey();
			if (cur != prev) {
				if (prev != 0) {
					res.add(Arrays.asList(start, point[0], prev));
				}
				start = point[0];
				prev = cur;
			}
		}

		return res;
	}

}

package com.jasper.twopoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC607_TwoSumIII {

	private List<Integer> list = null;
	private Map<Integer, Integer> map = null;

	public LC607_TwoSumIII() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}

	public void add(int number) {
		if (map.containsKey(number)) {
			map.put(number, map.get(number) + 1);
		} else {
			map.put(number, 1);
		}
	}

	public boolean find(int value) {

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			if (value - num == num) {
				if (map.get(num) > 1) {
					return true;
				} else {
					return false;
				}
			} else if (map.containsKey(value - num)) {
				return true;
			}
		}

		return false;
	}

}

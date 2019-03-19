package com.jasper.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC774_RepeatedDNA {

	public List<String> findRepeatedDna(String s) {

		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			map.put(sub, map.getOrDefault(sub, 0) + 1);
		}

		for (String sub : map.keySet()) {
			if (map.get(sub) > 1) {
				result.add(sub);
			}
		}

		return result;
	}
}

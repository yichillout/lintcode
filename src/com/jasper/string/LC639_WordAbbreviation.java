package com.jasper.string;

import java.util.HashMap;
import java.util.Map;

public class LC639_WordAbbreviation {

	public String[] wordsAbbreviation(String[] dict) {

		String[] results = new String[dict.length];
		int[] prefix = new int[dict.length];

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < dict.length; i++) {
			prefix[i] = 1;
			results[i] = getAbbrevation(dict[i], prefix[i]);
			map.put(results[i], map.getOrDefault(results[i], 0) + 1);
		}

		while (true) {
			boolean unique = true;
			for (int i = 0; i < results.length; i++) {
				if (map.get(results[i]) > 1) {
					prefix[i]++;
					results[i] = getAbbrevation(dict[i], prefix[i]);
					unique = false;
					map.put(results[i], map.getOrDefault(results[i], 0) + 1);
				}
			}
			if (unique == true) {
				break;
			}
		}

		return results;
	}

	private String getAbbrevation(String s, int p) {
		if (p >= s.length() - 2) {
			return s;
		}
		return s.substring(0, p) + (s.length() - p - 1) + s.substring(s.length() - 1);
	}

}

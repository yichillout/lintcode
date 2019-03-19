package com.jasper.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC772_GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] sc = s.toCharArray();
			Arrays.sort(sc);
			String key = String.valueOf(sc);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(s);
		}
		return new ArrayList<>(map.values());
	}

}

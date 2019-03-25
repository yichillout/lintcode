package com.jasper.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC828_WordPattern {

	public boolean wordPattern(String pattern, String teststr) {
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		String[] words = teststr.split(" ");

		if (words.length != pattern.length())
			return false;

		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i))) {
				if (set.contains(words[i])) {
					return false;
				}
				map.put(pattern.charAt(i), words[i]);
				set.add(words[i]);
			} else {
				String str = map.get(pattern.charAt(i));
				if (!str.equals(words[i])) {
					return false;
				}
			}
		}

		return true;
	}
}

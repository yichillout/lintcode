package com.jasper.hashtable;

import java.util.HashMap;
import java.util.Map;

class ValidWordAbbr {

	Map<String, Integer> dict;
	Map<String, Integer> abbr;

	public ValidWordAbbr(String[] dictionary) {
		dict = new HashMap<String, Integer>();
		abbr = new HashMap<String, Integer>();
		for (String str : dictionary) {
			dict.put(str, dict.getOrDefault(str, 0) + 1);
			String a = getAbbr(str);
			abbr.put(a, abbr.getOrDefault(a, 0) + 1);
		}
	}

	public boolean isUnique(String word) {
		String a = getAbbr(word);
		return dict.getOrDefault(word, 0) == abbr.getOrDefault(a, 0);
	}

	private String getAbbr(String word) {
		if (2 >= word.length())
			return word;
		return word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
	}
}

public class LC648_UniqueWordAbbreviation {

}

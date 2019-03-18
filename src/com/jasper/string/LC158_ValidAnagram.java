package com.jasper.string;

public class LC158_ValidAnagram {

	public boolean anagram(String s, String t) {
		if (s == null || t == null)
			return false;

		int[] sCount = new int[256];
		int[] tCount = new int[256];

		for (char c : s.toCharArray()) {
			sCount[c]++;
		}

		for (char c : t.toCharArray()) {
			tCount[c]++;
		}

		for (int i = 0; i < 256; i++) {
			if (sCount[i] != tCount[i]) {
				return false;
			}
		}

		return true;
	}
}

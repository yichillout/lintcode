package com.jasper.string;

public class LC646_FirstPositionUniqueCharacter {

	public int firstUniqChar(String s) {
		int[] count = new int[256];
		char[] charList = s.toCharArray();

		for (char c : charList) {
			count[c]++;
		}

		for (int i = 0; i < charList.length; i++) {
			if (count[charList[i]] == 1) {
				return i;
			}
		}

		return -1;
	}
}
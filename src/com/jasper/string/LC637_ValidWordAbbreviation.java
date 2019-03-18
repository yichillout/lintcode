package com.jasper.string;

public class LC637_ValidWordAbbreviation {

	public boolean validWordAbbreviation(String word, String abbr) {
		int i = 0, j = 0;
		char[] s = word.toCharArray();
		char[] t = abbr.toCharArray();

		while (i < s.length && j < t.length) {
			if (Character.isDigit(t[j])) {
				if (t[j] == '0') {
					return false;
				}
				int val = 0;
				while (j < t.length && Character.isDigit(t[j])) { // 里面while里面一定不能忘记条件判断
					val = val * 10 + t[j] - '0';
					j++;
				}
				i += val;
			} else {
				if (s[i++] != t[j++]) {
					return false;
				}
			}
		}
		return i == s.length && j == t.length;
	}

}

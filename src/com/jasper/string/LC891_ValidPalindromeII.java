package com.jasper.string;

public class LC891_ValidPalindromeII {

	public boolean validPalindrome(String s) {

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				break;
			}
			start++;
			end--;
		}

		if (start >= end)
			return true;

		return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
	}

	public boolean isPalindrome(String str, int start, int end) {

		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}
}

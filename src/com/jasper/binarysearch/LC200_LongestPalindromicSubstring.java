package com.jasper.binarysearch;

public class LC200_LongestPalindromicSubstring {

	// Solution 1 : DP O(n^2)
	public String longestPalindrome1(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int n = s.length();
		boolean[][] isPalindrome = new boolean[n][n];

		int longest = 1, start = 0;
		for (int i = 0; i < n; i++) {
			isPalindrome[i][i] = true;
		}

		for (int i = 0; i < n - 1; i++) {
			isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			if (isPalindrome[i][i + 1]) {
				start = i;
				longest = 2;
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 2; j < n; j++) {
				isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);

				if (isPalindrome[i][j] && j - i + 1 > longest) {
					start = i;
					longest = j - i + 1;
				}
			}
		}

		return s.substring(start, start + longest);
	}

	// Solution 2 : O(n^3)
	public String longestPalindrome2(String s) {

		if (s == null || s.length() == 0)
			return "";

		int start = 0;
		int len = 1;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (j - i + 1 > len && isPalindrome(s, i, j)) {
					start = i;
					len = j - i + 1;
				}
			}
		}

		return s.substring(start, start + len);

	}

	private boolean isPalindrome(String s, int start, int end) {

		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}

	// Solution 3 : O(n^2)
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int start = 0, len = 0, longest = 0;
		for (int i = 0; i < s.length(); i++) {
			len = findLongestPalindromeFrom(s, i, i);
			if (len > longest) {
				longest = len;
				start = i - len / 2;
			}

			len = findLongestPalindromeFrom(s, i, i + 1);
			if (len > longest) {
				longest = len;
				start = i - len / 2 + 1;
			}
		}

		return s.substring(start, start + longest);
	}

	private int findLongestPalindromeFrom(String s, int left, int right) {
		int len = 0;
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			}
			len += left == right ? 1 : 2;
			left--;
			right++;
		}

		return len;
	}

}

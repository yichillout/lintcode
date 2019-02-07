package com.jasper.dp;

public class LC667_LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {

		int n = s.length();
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int[][] f = new int[n][n];
		int i, j, len;

		for (i = 0; i < n; ++i) {
			f[i][i] = 1;
		}

		for (i = 0; i < n - 1; ++i) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				f[i][i + 1] = 2;
			} else {
				f[i][i + 1] = 1;
			}
		}

		for (len = 3; len <= n; ++len) {
			for (i = 0; i <= n - len; ++i) {
				j = i + len - 1;
				f[i][j] = f[i][j - 1];
				if (f[i + 1][j] > f[i][j]) {
					f[i][j] = f[i + 1][j];
				}
				if (s.charAt(i) == s.charAt(j) && f[i + 1][j - 1] + 2 > f[i][j]) {
					f[i][j] = f[i + 1][j - 1] + 2;
				}
			}
		}

		int res = 0;
		for (i = 0; i < n; ++i) {
			for (j = i; j < n; ++j) {
				if (f[i][j] > res) {
					res = f[i][j];
				}
			}
		}

		return res;
	}

}

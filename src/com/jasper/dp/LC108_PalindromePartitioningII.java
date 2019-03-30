package com.jasper.dp;

public class LC108_PalindromePartitioningII {

	public int minCut(String s) {
		char[] ss = s.toCharArray();
		int n = ss.length;
		if (n == 0) {
			return 0;
		}

		boolean[][] isPalin = calcPalin(ss, n);
		int[] f = new int[n + 1];

		int i, j;
		for (i = 1; i <= n; i++) {
			f[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (isPalin[j][i - 1]) {
					f[i] = Math.min(f[i], f[j] + 1);
				}
			}
		}

		return f[n] - 1;
	}

	public boolean[][] calcPalin(char[] s, int n) {

		int i, j, mid;
		boolean[][] isPalin = new boolean[n][n];

		for (i = 0; i < n; i++) {
			for (j = i; j < n; j++) {
				isPalin[i][j] = false;
			}
		}

		// following code is very important
		// mid is axis
		for (mid = 0; mid < n; mid++) {
			// odd length Palindrome
			i = j = mid;
			while (i >= 0 && j < n && s[i] == s[j]) {
				isPalin[i][j] = true;
				i--;
				j++;
			}

			// even length Palindrome
			i = mid;
			j = mid + 1;
			while (i >= 0 && j < n && s[i] == s[j]) {
				isPalin[i][j] = true;
				i--;
				j++;
			}
		}

		return isPalin;
	}
}

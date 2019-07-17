package com.jasper.dp;

public class LC668_OnesAndZeroes {

	public int findMaxForm(String[] strs, int m, int n) {

		if (strs.length == 0) {
			return 0;
		}

		int T = strs.length;
		int[] cnt0 = new int[T];
		int[] cnt1 = new int[T];

		int i, j, k;
		for (i = 0; i < T; i++) {
			char[] s = strs[i].toCharArray();
			cnt0[i] = cnt1[i] = 0;
			for (j = 0; j < s.length; j++) {
				if (s[j] == '0') {
					cnt0[i]++;
				} else {
					cnt1[i]++;
				}
			}
		}

		int[][][] f = new int[T + 1][m + 1][n + 1];
		for (i = 0; i <= T; i++) {
			for (j = 0; j <= m; j++) {
				for (k = 0; k <= n; k++) {
					if (i == 0) {
						f[i][j][k] = 0;
						continue;
					}

					// not using stirng i - 1
					f[i][j][k] = f[i - 1][j][k];

					// take string i - 1
					if (j >= cnt0[i - 1] && k >= cnt1[i - 1]) {
						f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - cnt0[i - 1]][k - cnt1[i - 1]] + 1);
					}
				}
			}
		}

		return f[T][m][n];
	}

}

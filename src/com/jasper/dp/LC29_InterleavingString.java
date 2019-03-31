package com.jasper.dp;

public class LC29_InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		char[] ss1 = s1.toCharArray();
		char[] ss2 = s2.toCharArray();
		char[] ss3 = s3.toCharArray();

		int n = ss1.length;
		int m = ss2.length;

		if (n + m != ss3.length) {
			return false;
		}

		boolean[][] f = new boolean[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {

				if (i == 0 && j == 0) {
					f[i][j] = true;
					continue;
				}

				f[i][j] = false;

				if (i > 0 && ss1[i - 1] == ss3[i + j - 1]) {
					f[i][j] |= f[i - 1][j];
				}

				if (j > 0 && ss2[j - 1] == ss3[i + j - 1]) {
					f[i][j] |= f[i][j - 1];
				}
			}
		}
		return f[n][m];
	}
}

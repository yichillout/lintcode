package com.jasper.dp;

public class LC430_ScrambleString {

	public boolean isScramble(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();

		if (m != n) {
			return false;
		}

		boolean[][][] f = new boolean[n][n][n + 1];

		int i, j, w, len;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				f[i][j][1] = (s1.charAt(i) == s2.charAt(j));
			}
		}

		for (len = 2; len <= n; len++) {
			for (i = 0; i <= n - len; i++) {
				for (j = 0; j <= n - len; j++) {
					f[i][j][len] = false;

					// cut
					for (w = 1; w < len; w++) {
						// no swap
						if (f[i][j][w] && f[i + w][j + w][len - w]) {
							f[i][j][len] = true;
							break;
						}

						// swap
						if (f[i][j + len - w][w] && f[i + w][j][len - w]) {
							f[i][j][len] = true;
						}
					}
				}
			}
		}

		return f[0][0][n];
	}

}

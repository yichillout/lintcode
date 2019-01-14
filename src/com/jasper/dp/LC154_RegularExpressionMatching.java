package com.jasper.dp;

public class LC154_RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		
		char[] ss = s.toCharArray();
		char[] pp = p.toCharArray();

		int m = ss.length;
		int n = pp.length;

		boolean[][] f = new boolean[m + 1][n + 1];

		int i, j;
		for (i = 0; i <= m; i++) {
			for (j = 0; j <= n; j++) {
				// both s and p are empty
				if (i == 0 && j == 0) {
					f[i][j] = true;
					continue;
				}

				// s is not empty, p is empty
				if (j == 0) {
					f[i][j] = false;
					continue;
				}

				f[i][j] = false;
				if (pp[j - 1] != '*') {
					if (i > 0 && (pp[j - 1] == '.' || pp[j - 1] == ss[i - 1])) {
						f[i][j] |= f[i - 1][j - 1];
					}
				} else {
					// .........c*
					// c=pp[j-2]
					// 0c
					if (j > 1) {
						f[i][j] |= f[i][j - 2];
					}

					// >=1c
					if (i > 0 && j > 1 && (pp[j - 2] == '.' || pp[j - 2] == ss[i - 1])) {
						f[i][j] |= f[i - 1][j];
					}

				}
			}
		}

		return f[m][n];
	}
}

package com.jasper.dp;

public class LC118_DistinctSubsequences {

	public int numDistinct(String S, String T) {
		char[] s1 = S.toCharArray();
		char[] t1 = T.toCharArray();

		int m = s1.length;
		int n = t1.length;

		int[][] f = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				// T is empty
				if (j == 0) {
					f[i][j] = 1;
					continue;
				}

				// S is empty
				if (i == 0) {
					f[i][j] = 0;
					continue;
				}

				f[i][j] = f[i - 1][j];
				if (s1[i - 1] == t1[j - 1])
					f[i][j] += f[i - 1][j - 1];

			}
		}

		return f[m][n];
	}

}

package com.jasper.dp;

public class LC77_LongestCommonSubsequence {

	public int longestCommonSubsequence(String A, String B) {
		int n = A.length();
		int m = B.length();

		int[][] f = new int[n + 1][m + 1];
		int[][] pi = new int[n + 1][m + 1];

		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < f[0].length; j++) {
				if (i == 0 || j == 0) {
					f[i][j] = 0;
					continue;
				}

				f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);

				if (f[i][j] == f[i - 1][j]) {
					pi[i][j] = 1;
				} else {
					pi[i][j] = 2;
				}

				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
					if (f[i][j] == f[i - 1][j - 1]) {
						pi[i][j] = 3;
					}

				}
			}
		}

		char[] res = new char[f[n][m]];

		int p = f[n][m] - 1;
		int i = n;
		int j = m;

		while (i > 0 && j > 0) {
			if (pi[i][j] == 1) {
				i--;
			} else if (pi[i][j] == 2) {
				j--;
			} else {
				res[p] = A.charAt(i - 1);
				i--;
				j--;
				p--;
			}
		}

		for (i = 0; i < f[n][m]; i++) {
			System.out.print(res[i]);
		}
		return f[n][m];
	}
}

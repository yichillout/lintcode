package com.jasper.dp;

public class LC437_CopyBooks {

	public int copyBooks(int[] pages, int K) {

		int n = pages.length;

		if (n == 0) {
			return 0;
		}

		if (K > n) {
			K = n;
		}

		int[][] f = new int[K + 1][n + 1];
		int i, j, k, s;

		// 0 people
		f[0][0] = 0;
		for (i = 1; i <= n; i++) {
			f[0][i] = Integer.MAX_VALUE;
		}

		for (k = 1; k <= K; k++) {
			f[k][0] = 0;
			for (i = 1; i <= n; i++) {
				f[k][i] = Integer.MAX_VALUE;
				s = 0;
				for (j = i; j >= 0; j--) {
					if (f[k - 1][j] != Integer.MAX_VALUE) {
						f[k][i] = Math.min(f[k][i], Math.max(f[k - 1][j], s));
					}
					if (j > 0) {
						s += pages[j - 1];
					}
				}
			}

		}

		return f[K][n];
	}
}

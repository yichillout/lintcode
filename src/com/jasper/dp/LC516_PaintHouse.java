package com.jasper.dp;

public class LC516_PaintHouse {

	public int minCostII(int[][] C) {

		int n = C.length;
		if (n == 0) {
			return 0;
		}

		int K = C[0].length;
		if (K == 0) {
			return 0;
		}

		int[][] f = new int[n + 1][K];
		int i, j, k, a, b;

		// init
		for (k = 0; k < K; k++) {
			f[0][k] = 0;
		}

		for (i = 1; i <= n; i++) {
			// calculate minimum and second minimum among
			// f[i-1][0] ~ f[i-1][K-1]
			// minimum: f[i-1][a]
			// 2nd minimum: f[i-1][b]
			a = b = -1;
			for (j = 0; j < K; j++) {
				if (a == -1 || f[i - 1][j] < f[i - 1][a]) {
					b = a;
					a = j;
				} else if (b == -1 || f[i - 1][j] < f[i - 1][b]) {
					b = j;
				}
			}

			for (j = 0; j < K; j++) {
				if (j == a) {
					f[i][j] = f[i - 1][b] + C[i - 1][j];
				} else {
					f[i][j] = f[i - 1][a] + C[i - 1][j];
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for (j = 0; j < K; j++) {
			res = Math.min(res, f[n][j]);
		}

		return res;
	}

}

package com.jasper.dp;

public class LC168_BurstBalloons {

	public int maxCoins(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}

		int i, j, k, len;
		int[] A = new int[n + 2];

		A[0] = A[n + 1] = 1;
		for (i = 1; i <= n; i++) {
			A[i] = nums[i - 1];
		}

		n += 2;
		int[][] f = new int[n][n];

		for (i = 0; i < n - 1; i++) {
			f[i][i + 1] = 0;
		}

		for (len = 3; len <= n; len++) {
			for (i = 0; i <= n - len; i++) {
				j = i + len - 1;
				f[i][j] = 0;

				for (k = i + 1; k < j; k++) {
					f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + A[k] * A[i] * A[j]);
				}
			}
		}

		return f[0][n - 1];
	}
}

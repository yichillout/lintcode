package com.jasper.dp;

public class LC92_Backpack {

	public int backPack(int m, int[] A) {
		int n = A.length;
		if (n == 0) {
			return 0;
		}

		boolean[][] f = new boolean[n + 1][m + 1];
		int i, j;
		// f[i][j] 表示前i个物品能拼出总重量为j
		f[0][0] = true;
		for (j = 1; j <= m; j++) {
			f[0][j] = false;
		}

		for (i = 1; i <= n; i++) {
			for (j = 0; j <= m; j++) {
				f[i][j] = f[i - 1][j];
				if (A[i - 1] <= j) {
					f[i][j] = (f[i][j] || f[i - 1][j - A[i - 1]]);
				}
			}
		}

		int res = 0;
		for (i = m; i >= 0; i--) {
			if (f[n][i]) {
				res = i;
				break;
			}
		}

		return res;
	}
}

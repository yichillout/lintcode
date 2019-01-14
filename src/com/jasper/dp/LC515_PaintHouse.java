package com.jasper.dp;

public class LC515_PaintHouse {

	/**
	 * @param costs: n x 3 cost matrix
	 * @return: An integer, the minimum cost to paint all houses
	 */
	public int minCost(int[][] costs) {
		int n = costs.length;
		if (n == 0) {
			return 0;
		}

		int[][] f = new int[n + 1][3];
		f[0][0] = 0;
		f[0][1] = 0;
		f[0][2] = 0;

		// first i houses
		for (int i = 1; i <= n; i++) {
			// house i-1's color is j
			for (int j = 0; j < 3; j++) {
				f[i][j] = Integer.MAX_VALUE;
				// house i-2's color is k
				for (int k = 0; k < 3; k++) {
					if (j == k) {
						continue;
					}
					f[i][j] = Math.min(f[i][j], f[i - 1][k] + costs[i - 1][j]);
				}
			}
		}

		return Math.min(f[n][0], Math.min(f[n][1], f[n][2]));
	}

}

package com.jasper.dp;

public class LC110_MinimumPathSum {

	/**
	 * @param grid:
	 *            a list of lists of integers
	 * @return: An integer, minimizes the sum of all numbers along its path
	 */
	public int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int[][] f = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					f[i][j] = grid[i][j];
					continue;
				}

				f[i][j] = Integer.MAX_VALUE;
				if (i > 0) {
					f[i][j] = Math.min(f[i][j], f[i - 1][j]);
				}

				if (j > 0) {
					f[i][j] = Math.min(f[i][j], f[i][j - 1]);
				}

				f[i][j] += grid[i][j];
			}
		}

		return f[m - 1][n - 1];
	}

	public int minPathSumWithRA(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int[][] f = new int[2][n];

		int now = 0;
		int old = 0;
		for (int i = 0; i < m; i++) {
			old = now;
			now = 1 - now; // 0-->1-->0
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					f[now][j] = grid[0][0];
					continue;
				}

				f[now][j] = Integer.MAX_VALUE;
				if (i > 0) {
					f[now][j] = Math.min(f[now][j], f[old][j]);
				}

				if (j > 0) {
					f[now][j] = Math.min(f[now][j], f[now][j - 1]);
				}

				f[now][j] += grid[i][j];
			}
		}

		return f[now][n - 1];
		
		/*   3 row:
		 *   now += 1; if(now == 3) now = 0;
		 *   prev = now - 1; if(prev == -1) prev = 2;
		 *   prev2 = prev -1; if(prev2 == -1) prev2 = 2;
		 */
	}
}

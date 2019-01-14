package com.jasper.dp;

public class LC115_UniquePathsII {

	/**
	 * @param obstacleGrid: A list of lists of integers
	 * @return: An integer
	 */
	public int uniquePathsWithObstacles(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;

		int n = grid[0].length;
		if (n == 0)
			return 0;

		int[][] f = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					f[i][j] = 0; // important
					continue;
				}

				if (i == 0 && j == 0) {
					f[i][j] = 1;
					continue;
				}

				f[i][j] = 0;
				if (i > 0) {
					f[i][j] += f[i - 1][j];
				}
				if (j > 0) {
					f[i][j] += f[i][j - 1];
				}
			}
		}

		return f[m - 1][n - 1];
	}

}

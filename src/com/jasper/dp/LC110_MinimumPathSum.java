package com.jasper.dp;

public class LC110_MinimumPathSum {

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

		/*
		 * 3 row: 
		 * now += 1; if(now == 3) now = 0; 
		 * prev = now - 1; if(prev == -1) prev = 2; 
		 * prev2 = prev -1; if(prev2 == -1) prev2 = 2;
		 */
	}

	public int minPathSumWithPrinter(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		int[][] f = new int[m][n];
		int[][] pi = new int[m][n];
		// pi[i][j] = 1 : from(0, 0) to (i, j), last step was from (i-1, j);
		// pi[i][j] = 2 : from(0, 0) to (i, j), last step was from (i, j-1);

		// 1 3 1
		// 1 5 1
		// 4 2 1
		// 1-->3-->1-->1-->1

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					f[i][j] = grid[i][j];
					continue;
				}

				f[i][j] = Integer.MAX_VALUE;
				if (i > 0) {
					f[i][j] = Math.min(f[i][j], f[i - 1][j]);
					if (f[i][j] == f[i - 1][j]) {
						pi[i][j] = 1; // from up
					}
				}

				if (j > 0) {
					f[i][j] = Math.min(f[i][j], f[i][j - 1]);
					if (f[i][j] == f[i][j - 1]) {
						pi[i][j] = 2; // from left
					}
				}

				f[i][j] += grid[i][j];
			}
		}

		int[] path = new int[m + n - 1];
		// reverse order
		int x = m - 1;
		int y = n - 1;
		for (int i = m + n - 2; i >= 0; i--) {
			path[i] = grid[x][y];
			if (i > 0) {
				if (pi[x][y] == 1) {
					x--; // from up
				} else {
					y--; // from left
				}
			}
		}

		for (int i = 0; i < m + n - 1; i++) {
			if (i > 0) {
				System.out.print("-->");
			}
			System.out.print(path[i]);
		}

		System.out.print("\n");

		return f[m - 1][n - 1];

	}

}

package com.jasper.dp;

public class LC535_BombEnemy {
	
	/**
	 * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
	 * @return: an integer, the maximum enemies you can kill using one bomb
	 */
	public int maxKilledEnemies(char[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;

		int[][] up = new int[m][n];
		int[][] down = new int[m][n];
		int[][] left = new int[m][n];
		int[][] right = new int[m][n];

		// calc up
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'W') {
					up[i][j] = 0;
					continue;
				}

				if (grid[i][j] == 'E') {
					up[i][j] = 1;
				} else {
					up[i][j] = 0;
				}

				if (i > 0) {
					up[i][j] += up[i - 1][j];
				}
			}
		}

		// calc down
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'W') {
					down[i][j] = 0;
					continue;
				}

				if (grid[i][j] == 'E') {
					down[i][j] = 1;
				} else {
					down[i][j] = 0;
				}

				if (i < m - 1) {
					down[i][j] += down[i + 1][j];
				}
			}
		}

		// calc left
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'W') {
					left[i][j] = 0;
					continue;
				}

				if (grid[i][j] == 'E') {
					left[i][j] = 1;
				} else {
					left[i][j] = 0;
				}

				if (j > 0) {
					left[i][j] += left[i][j - 1];
				}
			}
		}

		// calc right
		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] == 'W') {
					right[i][j] = 0;
					continue;
				}

				if (grid[i][j] == 'E') {
					right[i][j] = 1;
				} else {
					right[i][j] = 0;
				}

				if (j < n - 1) {
					right[i][j] += right[i][j + 1];
				}
			}
		}

		// printGrid(up);
		// printGrid(down);
		// printGrid(left);
		// printGrid(right);

		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0') {
					result = Math.max(result, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
				}
			}
		}

		return result;
	}

	private void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("--------------------------");
	}
}
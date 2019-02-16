package com.jasper.matrix;

public class LC574_BuildPostOffice {

	public int shortestDistance(int[][] grid) {

		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		int[] rowCount = new int[grid.length];
		int[] colCount = new int[grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rowCount[i]++;
					colCount[j]++;
				}
			}
		}

		int[] rowDistance = new int[grid.length];
		int[] colDistance = new int[grid[0].length];

		getDistances(rowCount, grid.length, rowDistance);
		getDistances(colCount, grid[0].length, colDistance);

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					int temp = rowDistance[i] + colDistance[j];
					ans = Math.min(ans, temp);
				}
			}
		}

		return ans;
	}

	private void getDistances(int[] ary, int size, int[] ans) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ans[i] += ary[j] * (Math.abs(j - i));
			}
		}
	}

}

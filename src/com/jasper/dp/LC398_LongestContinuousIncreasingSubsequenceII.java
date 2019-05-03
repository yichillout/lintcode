package com.jasper.dp;

public class LC398_LongestContinuousIncreasingSubsequenceII {

	public int longestContinuousIncreasingSubsequence2(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int n = matrix.length;
		int m = matrix[0].length;

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int[][] cache = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(matrix, i, j, dir, cache);
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cache[i][j] > result) {
					result = cache[i][j];
				}
			}
		}

		return result;
	}

	private int dfs(int[][] matrix, int x, int y, int[][] dir, int[][] cache) {
		if (cache[x][y] > 0) {
			return cache[x][y];
		}

		cache[x][y] = 1;
		for (int i = 0; i < dir.length; i++) {
			int xx = x + dir[i][0];
			int yy = y + dir[i][1];
			if (xx >= 0 && xx < matrix.length && yy >= 0 && yy < matrix[0].length && matrix[xx][yy] > matrix[x][y]) {
				cache[x][y] = Math.max(cache[x][y], dfs(matrix, xx, yy, dir, cache) + 1);
			}
		}

		return cache[x][y];
	}
}

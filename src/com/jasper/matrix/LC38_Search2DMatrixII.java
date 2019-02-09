package com.jasper.matrix;

public class LC38_Search2DMatrixII {

	public int searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}

		// from bottom left to top right
		int n = matrix.length;
		int m = matrix[0].length;
		int x = n - 1;
		int y = 0;
		int count = 0;

		while (x >= 0 && y < m) {
			if (matrix[x][y] < target) {
				y++;
			} else if (matrix[x][y] > target) {
				x--;
			} else {
				count++;
				x--;
				y++;
			}
		}
		return count;
	}
}

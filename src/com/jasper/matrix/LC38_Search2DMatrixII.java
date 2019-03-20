package com.jasper.matrix;

public class LC38_Search2DMatrixII {

	// This matrix has the following properties:
	// 1. Integers in each row are sorted from left to right.
	// 2.Integers in each column are sorted from up to bottom.
	// 3.No duplicate integers in each row or column.

	public int searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int count = 0;

		int n = matrix.length;
		int m = matrix[0].length;
		int row = n - 1;
		int col = 0;

		while (row >= 0 && col < m) {
			if (matrix[row][col] == target) {
				count++;
				row--;
				col++;
			} else if (matrix[row][col] > target) {
				row--;
			} else {
				col++;
			}
		}

		return count;
	}
}

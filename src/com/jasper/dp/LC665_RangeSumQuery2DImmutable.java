package com.jasper.dp;

class NumMatrix {

	int[][] preSum = null;

	public NumMatrix(int[][] matrix) {
		preSum = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 1; i < preSum.length; i++) {
			for (int j = 1; j < preSum[0].length; j++) {
				preSum[i][j] = matrix[i - 1][j - 1] + preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1];
			}
		}
		// print(preSum);
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
	}

	private void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println("");
		}
	}
}

public class LC665_RangeSumQuery2DImmutable {

}

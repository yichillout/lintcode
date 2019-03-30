package com.jasper.matrix;

public class LC944_MaximumSubmatrix {

	int n, m;

	public int maxSubmatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return 0;
		}

		n = matrix.length;
		m = matrix[0].length;

		int[][] prefixColSum = getPrefixColSum(matrix);

		int max = Integer.MIN_VALUE;
		for (int up = 0; up < n; up++) {
			for (int down = up; down < n; down++) {
				int[] arr = compression(matrix, up, down, prefixColSum);
				max = Math.max(max, maximumSubarray(arr));
			}
		}

		return max;
	};

	private int maximumSubarray(int[] arr) {
		int min = 0, max = Integer.MIN_VALUE, sum = 0;

		for (int i = 0; i < m; i++) {
			sum += arr[i];
			max = Math.max(max, sum - min);
			min = Math.min(min, sum);
		}

		return max;
	}

	private int[] compression(int[][] matrix, int up, int down, int[][] prefixColSum) {
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = prefixColSum[down + 1][i] - prefixColSum[up][i];
		}

		return arr;
	}

	private int[][] getPrefixColSum(int[][] matrix) {
		int[][] sum = new int[n + 1][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum[i + 1][j] = sum[i][j] + matrix[i][j];
			}
		}

		return sum;
	}
}

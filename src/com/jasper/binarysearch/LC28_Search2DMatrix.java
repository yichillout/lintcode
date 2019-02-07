package com.jasper.binarysearch;

public class LC28_Search2DMatrix {

	// Binary Search Twice
	public boolean searchMatrix1(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return false;
		}

		int row = matrix.length;
		int column = matrix[0].length;

		// find the row index, the last number <= target
		int start = 0, end = row - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (matrix[mid][0] == target) {
				return true;
			} else if (matrix[mid][0] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (matrix[end][0] <= target) {
			row = end;
		} else if (matrix[start][0] <= target) {
			row = start;
		} else {
			return false;
		}

		// find the column index, the number equal to target
		start = 0;
		end = column - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (matrix[row][mid] == target) {
				return true;
			} else if (matrix[row][mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (matrix[row][start] == target) {
			return true;
		} else if (matrix[row][end] == target) {
			return true;
		}
		return false;
	}

	// Binary Search Once
	public boolean searchMatrix2(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0) {
			return false;
		}

		if (matrix[0] == null || matrix[0].length == 0) {
			return false;
		}

		int row = matrix.length;
		int column = matrix[0].length;

		int start = 0, end = row * column - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int number = matrix[mid / column][mid % column];
			if (number == target) {
				return true;
			} else if (number > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return false;
	}
}

package com.jasper.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC401_KthSmallestNumberInSortedMatrix {

	// Solution 1
	class Pair {
		int row;
		int col;
		int val;

		public Pair(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}

	class PairComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return a.val - b.val;
		}
	}

	public int kthSmallest1(int[][] matrix, int k) {

		PriorityQueue<Pair> pq = new PriorityQueue<>(k, new PairComparator());

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != 0) {
				pq.offer(new Pair(i, 0, matrix[i][0]));
			}
		}

		for (int i = 0; i < k - 1; i++) {
			Pair pair = pq.poll();
			if (pair.col + 1 < matrix[0].length) {
				pair.col++;
				pair.val = matrix[pair.row][pair.col];
				pq.offer(pair);
			}
		}

		return pq.peek().val;
	}

	// Solution 2 : 二分法
	class ResultType {
		public int num;
		public boolean exists;

		public ResultType(boolean e, int n) {
			exists = e;
			num = n;
		}
	}

	public ResultType check(int value, int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		boolean exists = false;
		int num = 0;
		int i = n - 1, j = 0;
		while (i >= 0 && j < m) {
			if (matrix[i][j] == value)
				exists = true;

			if (matrix[i][j] <= value) {
				num += i + 1;
				j += 1;
			} else {
				i -= 1;
			}
		}

		return new ResultType(exists, num);
	}

	public int kthSmallest2(int[][] matrix, int k) {
		// write your code here
		int n = matrix.length;
		int m = matrix[0].length;

		int left = matrix[0][0];
		int right = matrix[n - 1][m - 1];

		// left + 1 < right
		while (left <= right) {
			int mid = left + (right - left) / 2;
			ResultType type = check(mid, matrix);
			if (type.exists && type.num == k) {
				return mid;
			} else if (type.num < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}
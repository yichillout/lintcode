package com.jasper.binarysearch;

public class LC459_ClosestNumberInSortedArray {

	public int closestNumber(int[] A, int target) {

		int index = findLastLess(A, target);

		if (index == -1) {
			return 0;
		}

		if (index == A.length - 1) {
			return index;
		}

		if (Math.abs(A[index] - target) >= Math.abs(A[index + 1] - target)) {
			return index + 1;
		} else {
			return index;
		}

	}

	private int findLastLess(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (A[end] <= target) {
			return end;
		}

		if (A[start] <= target) {
			return start;
		}

		return -1;
	}
}

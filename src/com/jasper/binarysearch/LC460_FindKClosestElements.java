package com.jasper.binarysearch;

public class LC460_FindKClosestElements {

	public int[] kClosestNumbers(int[] A, int target, int k) {
		int left = findLowerClosest(A, target);
		int right = left + 1;

		int[] results = new int[k];
		for (int i = 0; i < k; i++) {
			if (isLeftCloser(A, target, left, right)) {
				results[i] = A[left];
				left--;
			} else {
				results[i] = A[right];
				right++;
			}
		}

		return results;
	}

	private boolean isLeftCloser(int[] A, int target, int left, int right) {
		if (left < 0) {
			return false;
		}

		if (right >= A.length) {
			return true;
		}

		int l = Math.abs(A[left] - target);
		int r = Math.abs(A[right] - target);

		if (l <= r)
			return true;
		else
			return false;
	}

	private int findLowerClosest(int[] A, int target) {
		// find the last element smaller than target
		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				end = mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (A[end] < target) {
			return end;
		}
		if (A[start] < target) {
			return start;
		}

		return -1;
	}

}

package com.jasper.binarysearch;

public class LC61_SearchForARange {

	// Solution 1 : binary search
	public int[] searchRange1(int[] A, int target) {

		if (A == null || A.length == 0)
			return new int[] { -1, -1 };

		int index1 = -1;
		int index2 = -1;

		int start = 0;
		int end = A.length - 1;

		// first position of target
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

		if (A[start] == target) {
			index1 = start;
		} else if (A[end] == target) {
			index1 = end;
		} else {
			return new int[] { -1, -1 };
		}

		start = 0;
		end = A.length - 1;

		// last position of target
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				start = mid;
			} else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (A[end] == target) {
			index2 = end;
		} else if (A[start] == target) {
			index2 = start;
		} else {
			return new int[] { -1, -1 };
		}

		return new int[] { index1, index2 };
	}

	// Solution 2 : not binary search
	public int[] searchRange2(int[] A, int target) {

		int[] range = new int[2];
		int start = -1;
		int end = -1;
		for (int i = 0; i < A.length; i++) {
			if (start == -1 && A[i] == target) {
				start = i;
				while (i + 1 < A.length && A[i + 1] == A[i])
					i++;
				end = i;
				break;
			}
		}

		range[0] = start;
		range[1] = end;
		return range;
	}

}

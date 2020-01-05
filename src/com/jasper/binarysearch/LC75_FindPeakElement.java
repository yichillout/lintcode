package com.jasper.binarysearch;

public class LC75_FindPeakElement {

	public int findPeak(int[] A) {

		int start = 1;
		int end = A.length - 2;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < A[mid + 1]) {
				start = mid + 1;
			} else if (A[mid] < A[mid - 1]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}

		if (A[start] > A[end]) {
			return start;
		}

		return end;
	}

}

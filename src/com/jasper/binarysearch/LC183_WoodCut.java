package com.jasper.binarysearch;

public class LC183_WoodCut {

	public int woodCut(int[] L, int k) {

		int start = 1;
		int end = 0;

		for (int item : L) {
			end = Math.max(end, item);
		}

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (count(L, mid) >= k) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (count(L, end) >= k) {
			return end;
		}

		if (count(L, start) >= k) {
			return start;
		}
		return 0;
	}

	private int count(int[] L, int len) {
		int sum = 0;
		for (int item : L) {
			sum += item / len;
		}
		return sum;
	}

}

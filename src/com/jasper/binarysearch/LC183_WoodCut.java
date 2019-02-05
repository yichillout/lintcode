package com.jasper.binarysearch;

public class LC183_WoodCut {

	public int woodCut(int[] L, int k) {

		int l = 1;
		int r = 0;
		for (int item : L) {
			r = Math.max(r, item);
		}

		while (l + 1 < r) {
			int mid = l + (r - l) / 2;
			if (count(L, mid) >= k) {
				l = mid;
			} else {
				r = mid;
			}
		}

		if (count(L, r) >= k) {
			return r;
		}

		if (count(L, l) >= k) {
			return l;
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

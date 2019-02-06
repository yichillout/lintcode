package com.jasper.binarysearch;

public class LC633_FindTheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		
		int l = 1;
		int r = nums.length - 1; // n

		while (l + 1 < r) {
			int mid = l + (r - l) / 2;
			if (count(nums, mid) <= mid) {
				l = mid;
			} else {
				r = mid;
			}
		}

		if (count(nums, l) <= l) {
			return r;
		}
		return l;
	}

	private int count(int[] nums, int mid) {
		int cnt = 0;
		for (int item : nums) {
			if (item <= mid) {
				cnt++;
			}
		}
		return cnt;
	}

}

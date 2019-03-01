package com.jasper.slidingwindow;

public class LC406_MinimumSizeSubarraySum {

	public int minimumSize(int[] nums, int s) {

		int j = 0;
		int result = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int tmp = Integer.MAX_VALUE;
			while (isValid(nums, i, j, s)) {
				tmp = Math.min(tmp, i - j + 1);
				j++;
			}
			result = Math.min(tmp, result);
		}

		if (result == Integer.MAX_VALUE) {
			return -1;
		}

		return result;
	}

	private boolean isValid(int[] nums, int i, int j, int t) {

		int sum = 0;

		for (int k = j; k <= i; k++) {
			sum += nums[k];
		}

		if (sum >= t) {
			return true;
		} else {
			return false;
		}
	}
}
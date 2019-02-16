package com.jasper.array;

public class LC604_WindowSum {

	public int[] winSum(int[] nums, int k) {
		if (nums == null || nums.length < k || k <= 0)
			return new int[0];

		int[] sums = new int[nums.length - k + 1];
		for (int i = 0; i < k; i++)
			sums[0] += nums[i];
		for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] - nums[i - 1] + nums[i + k - 1];
		}
		return sums;
	}

}

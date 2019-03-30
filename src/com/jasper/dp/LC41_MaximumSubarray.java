package com.jasper.dp;

public class LC41_MaximumSubarray {

	public int maxSubArray(int[] nums) {

		if (nums.length <= 1)
			return nums[0];

		int[] dp = new int[nums.length];

		dp[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (dp[i - 1] < 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = nums[i] + dp[i - 1];
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		return max;
	}
}

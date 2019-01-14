package com.jasper.dp;

public class LC191_MaximumProductSubarray {

	/**
	 * @param nums: An array of integers
	 * @return: An integer
	 */
	public int maxProduct(int[] nums) {

		int n = nums.length;
		if (n == 0)
			return 0;

		int[] f = new int[n];
		int[] g = new int[n];

		for (int i = 0; i < n; i++) {

			// f[i] = max{nums[i], max{nums[i]*f[i-1], nums[i]*g[i-1]}
			f[i] = nums[i];
			if (i > 0) {
				f[i] = Math.max(f[i], Math.max(nums[i] * f[i - 1], nums[i] * g[i - 1]));
			}

			// g[i] = min{nums[i], min{nums[i]*f[i-1], nums[i]*g[i-1]}
			g[i] = nums[i];
			if (i > 0) {
				g[i] = Math.min(g[i], Math.min(nums[i] * f[i - 1], nums[i] * g[i - 1]));
			}

		}

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, f[i]);
		}

		return res;
	}

}

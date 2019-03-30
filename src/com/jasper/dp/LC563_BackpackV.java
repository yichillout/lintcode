package com.jasper.dp;

public class LC563_BackpackV {

	// 滚动数组优化版
	public int backPackV(int[] nums, int m) {

		int n = nums.length;
		int[] f = new int[m + 1];

		int i, j;

		for (i = 1; i <= m; i++) {
			f[i] = 0;
		}

		f[0] = 1;
		for (i = 1; i <= n; i++) {
			for (j = m; j >= nums[i - 1]; j--) {
				f[j] += f[j - nums[i - 1]];
			}
		}

		return f[m];
	}
}

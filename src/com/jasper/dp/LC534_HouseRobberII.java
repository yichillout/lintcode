package com.jasper.dp;

public class LC534_HouseRobberII {

	public int houseRobber2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;

		if (n == 1) {
			return nums[0];
		}

		int[] A = new int[n - 1];

		// [0...n-2]
		for (int i = 0; i < n - 1; i++) {
			A[i] = nums[i];
		}

		int res1 = houseRobberWithRA(A);

		// [1...n-1]
		for (int i = 0; i < n - 1; i++) {
			A[i] = nums[i + 1];
		}

		int res2 = houseRobberWithRA(A);

		return Math.max(res1, res2);
	}

	public int houseRobberWithRA(int[] A) {

		if (A == null || A.length == 0)
			return 0;

		if (A.length == 1)
			return A[0];

		int n = A.length;

		int old, now, t;
		old = 0;
		now = A[0];

		for (int i = 2; i <= n; i++) {
			t = Math.max(old + A[i - 1], now); // t : f[i]
			old = now;
			now = t;
		}

		return now;
	}

}

package com.jasper.dp;

public class LC392_HouseRobber {

	// Solution 1
	public long houseRobber(int[] A) {

		if (A == null || A.length == 0)
			return 0;

		if (A.length == 1)
			return A[0];

		int n = A.length;

		long[] f = new long[n + 1];
		f[0] = 0;
		f[1] = A[0];

		for (int i = 2; i < f.length; i++) {
			f[i] = Math.max(f[i - 2] + A[i - 1], f[i - 1]);
		}

		return f[n];
	}

	// Solution 2
	public long houseRobberWithRA(int[] A) {

		if (A == null || A.length == 0)
			return 0;

		if (A.length == 1)
			return A[0];

		int n = A.length;

		long old, now, t;
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

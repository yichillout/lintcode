package com.jasper.dp;

public class LC515_PaintHouse {

	// Solution 1
	public int minCost1(int[][] costs) {

		int n = costs.length;

		if (n == 0)
			return 0;

		int[][] dp = new int[n + 1][3];

		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[0][2] = 0;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < 3; k++) {
					if (k == j)
						continue;

					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][k]);
				}
			}
		}

		return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
	}

	// Solution 2
	public int minCost(int[][] costs) {

		if (costs.length == 0)
			return 0;

		int n = costs.length;

		int[][] dp = new int[n][3];

		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
		}

		return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
	}

	// Solution 3 : 滚动数组
	public int minCost3(int[][] costs) {

		if (costs.length == 0)
			return 0;

		int n = costs.length;

		int[][] dp = new int[2][3];

		int num1 = 0;
		int num2 = 0;

		dp[num2][0] = costs[num2][0];
		dp[num2][1] = costs[num2][1];
		dp[num2][2] = costs[num2][2];

		for (int i = 1; i < n; i++) {
			num1 = num2;
			num2 = 1 - num1;
			dp[num2][0] = Math.min(dp[num1][1], dp[num1][2]) + costs[i][0];
			dp[num2][1] = Math.min(dp[num1][0], dp[num1][2]) + costs[i][1];
			dp[num2][2] = Math.min(dp[num1][0], dp[num1][1]) + costs[i][2];
		}

		return Math.min(dp[num2][0], Math.min(dp[num2][1], dp[num2][2]));
	}

}

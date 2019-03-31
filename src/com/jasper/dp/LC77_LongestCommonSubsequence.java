package com.jasper.dp;

public class LC77_LongestCommonSubsequence {

	public int longestCommonSubsequence(String A, String B) {
		int m = A.length();
		int n = B.length();
		char[] ca = A.toCharArray();
		char[] cb = B.toCharArray();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}

				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (ca[i - 1] == cb[j - 1]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp[m][n];
	}

}

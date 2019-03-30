package com.jasper.dp;

import java.util.Set;

public class LC107_WordBreak {

	// Solution 1 : DFS (Time Limit Exceeded)
	public boolean wordBreak1(String s, Set<String> dict) {

		// System.out.println(s);

		if (s.length() == 0)
			return true;

		boolean result = false;
		for (int i = 1; i <= s.length(); i++) {
			String str1 = s.substring(0, i);
			String str2 = s.substring(i);
			// System.out.println("str1:" + str1 + "; str2:" + str2);
			if (dict.contains(str1)) {
				result |= wordBreak1(str2, dict);
			}
		}
		return result;
	}

	// Solution 2 : DP
	public boolean wordBreak2(String s, Set<String> dict) {

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		int maxLength = getMaxLength(dict);

		for (int i = 1; i < s.length() + 1; i++) {
			int j = Math.max(i - maxLength, 0);
			while (j < i) {
				if (dp[j] == true && dict.contains(s.substring(j, i))) {
					dp[i] = true;
				}
				j++;
			}
		}

		return dp[dp.length - 1];
	}

	private int getMaxLength(Set<String> dict) {
		int maxLength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

}

package com.jasper.dp;

import java.util.Arrays;

public class LC602_RussianDollEnvelopes {

	// Solution 1 : (Time Limit Exceeded)
	public int maxEnvelopes(int[][] envelopes) {

		if (envelopes == null || envelopes.length == 0)
			return 0;

		int n = envelopes.length;

		Arrays.sort(envelopes, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});

		int[] f = new int[n];
		int i, j;
		for (i = 0; i < n; i++) {
			f[i] = 1;
			for (j = 0; j < i; j++) {
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}

		int res = 0;
		for (i = 0; i < n; i++) {
			res = Math.max(res, f[i]);
		}

		return res;
	}

}

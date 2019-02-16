package com.jasper.twopoint;

import java.util.Arrays;

public class LC382_TriangleCount {

	// to find a + b > c
	public int triangleCount(int S[]) {

		if (S == null || S.length < 3) {
			return 0;
		}

		int left;
		int right;
		int res = 0;

		Arrays.sort(S);

		for (int i = 2; i < S.length; i++) {
			left = 0;
			right = i - 1;
			while (left < right) {
				if (S[left] + S[right] > S[i]) {
					res = res + (right - left);
					right--;
				} else {
					left++;
				}
			}
		}
		return res;
	}

}

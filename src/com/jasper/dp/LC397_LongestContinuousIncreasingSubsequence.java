package com.jasper.dp;

public class LC397_LongestContinuousIncreasingSubsequence {

	/**
	 * @param A: An array of Integer
	 * @return: an integer
	 */
	public int longestIncreasingContinuousSubsequence(int[] A) {

		int n = A.length;

		// original order
		int res1 = lics(A, n);

		int i, j, t;
		i = 0;
		j = A.length - 1;
		while (i < j) {
			t = A[i];
			A[i] = A[j];
			A[j] = t;
			i++;
			j--;
		}

		// reverse order
		int res2 = lics(A, n);

		return Math.max(res1, res2);
	}

	private int lics(int[] A, int n) {
		int[] f = new int[n];
		int i = 0;
		for (i = 0; i < n; i++) {
			// case 1
			f[i] = 1;
			// case 2
			if (i > 0 && A[i - 1] < A[i]) {
				f[i] += f[i - 1];
			}
		}

		int res = 0;
		for (i = 0; i < n; i++) {
			res = Math.max(res, f[i]);
		}

		return res;
	}

}

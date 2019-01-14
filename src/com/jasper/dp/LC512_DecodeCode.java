package com.jasper.dp;

public class LC512_DecodeCode {

	/**
	 * @param s: a string, encoded message
	 * @return: an integer, the number of ways decoding
	 */
	public int numDecodings(String s) {

		char[] ss = s.toCharArray();
		int n = ss.length;
		if (n == 0) {
			return 0;
		}

		int[] f = new int[n + 1];
		// f[0]=1 is for the remaining number can be correct.
		f[0] = 1; 

		int i, j;
		for (i = 1; i <= n; i++) {
			f[i] = 0;

			// last 1 digit
			j = ss[i - 1] - '0';
			if (j >= 1 && j <= 9) {
				f[i] += f[i - 1];
			}

			// last 2 digits
			if (i > 1) {
				j = (ss[i - 2] - '0') * 10 + (ss[i - 1] - '0');
				if (j >= 10 && j <= 26) {
					f[i] += f[i - 2];
				}
			}
		}

		return f[n];
	}
}

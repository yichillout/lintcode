package com.jasper.string;

public class LC594_StrStrII {

	public int strStr2(String source, String target) {

		if (target == null) {
			return -1;
		}

		int m = target.length();

		if (m == 0 && source != null) {
			return 0;
		}

		if (source == null) {
			return -1;
		}

		int n = source.length();

		if (n == 0) {
			return -1;
		}

		int mod = Integer.MAX_VALUE / 33;
		int hash_target = 0;

		for (int i = 0; i < m; i++) {
			hash_target = (hash_target * 31 + target.charAt(i) - 'a') % mod;
			if (hash_target < 0) {
				hash_target += mod;
			}
		}

		int m31 = 1;
		for (int i = 0; i < m - 1; i++) {
			m31 = m31 * 31 % mod;
		}

		int value = 0;
		for (int i = 0; i < n; i++) {
			if (i >= m) {
				value = (value - m31 * (source.charAt(i - m) - 'a')) % mod;
			}
			value = (value * 31 + source.charAt(i) - 'a') % mod;
			if (value < 0) {
				value += mod;
			}
			if (i >= m - 1 && value == hash_target) {
				if (target.equals(source.substring(i - m + 1, i + 1))) {
					return i - m + 1;
				}
			}
		}

		return -1;
	}

}

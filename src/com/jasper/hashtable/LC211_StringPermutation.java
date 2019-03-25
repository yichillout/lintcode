package com.jasper.hashtable;

public class LC211_StringPermutation {

	public boolean Permutation(String A, String B) {
		int[] cnt = new int[256];

		for (int i = 0; i < A.length(); i++)
			cnt[A.charAt(i)]++;

		for (int i = 0; i < B.length(); i++)
			cnt[B.charAt(i)]--;

		for (int i = 0; i < 256; ++i)
			if (cnt[i] != 0)
				return false;

		return true;
	}
}

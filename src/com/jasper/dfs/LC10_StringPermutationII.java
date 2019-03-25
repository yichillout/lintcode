package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC10_StringPermutationII {

	public List<String> stringPermutation2(String str) {

		List<String> results = new ArrayList<>();

		boolean[] used = new boolean[str.length()];

		if (str == null || str.length() == 0) {
			results.add("");
			return results;
		}

		char[] chars = str.toCharArray();
		str = new String(chars);

		helper(results, new StringBuilder(), used, str);
		return results;
	}

	private void helper(List<String> results, StringBuilder builder, boolean[] used, String str) {

		if (builder.length() == str.length()) {
			results.add(new String(builder.toString()));
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			if (used[i] || (i != 0 && str.charAt(i) == str.charAt(i - 1) && !used[i - 1])) {
				continue;
			}

			builder.append(str.charAt(i));
			used[i] = true;
			helper(results, builder, used, str);
			builder.deleteCharAt(builder.length() - 1);
			used[i] = false;
		}
	}
}

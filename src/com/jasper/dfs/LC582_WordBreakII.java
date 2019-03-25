package com.jasper.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC582_WordBreakII {

	public List<String> wordBreak(String s, Set<String> wordDict) {
		Map<String, List<String>> memo = new HashMap<>();
		return helper(memo, s, wordDict);
	}

	private List<String> helper(Map<String, List<String>> memo, String s, Set<String> wordDict) {
		if (memo.containsKey(s)) {
			return memo.get(s);
		}

		List<String> buffer = new ArrayList<>();

		if (wordDict.contains(s)) {
			buffer.add(s);
		}

		for (int i = 1; i < s.length(); i++) {
			String s1 = s.substring(0, i);
			String s2 = s.substring(i);
			if (wordDict.contains(s1)) {
				List<String> segmentations = helper(memo, s2, wordDict);
				for (String segmentation : segmentations) {
					buffer.add(s1 + " " + segmentation);
				}
			}
		}

		memo.put(s, buffer);
		return buffer;
	}
}

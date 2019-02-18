package com.jasper.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC624_RemoveSubstrings {

	public int minLength(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (dict == null || dict.size() == 0) {
			return s.length();
		}

		int result = s.length();

		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		queue.offer(s);
		set.add(s);

		while (!queue.isEmpty()) {
			String str = queue.poll();
			result = Math.min(result, str.length());
			for (String d : dict) {
				for (String subS : indexes(str, d, set)) {
					queue.offer(subS);
					set.add(subS);
				}
			}
		}
		return result;
	}

	Set<String> indexes(String s, String d, Set<String> set) {
		Set<String> result = new HashSet<>();

		int index = -1;
		while ((index = s.indexOf(d, index + 1)) != -1) {
			StringBuilder sb = new StringBuilder(s);
			sb.delete(index, index + d.length());
			if (set.contains(sb.toString())) {
				continue;
			}
			result.add(sb.toString());
		}
		return result;
	}
}

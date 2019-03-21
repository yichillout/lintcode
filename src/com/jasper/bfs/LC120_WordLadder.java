package com.jasper.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC120_WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {

		if (start.equals(end))
			return 1;

		dict.add(start);
		dict.add(end);

		Map<String, Set<String>> graph = buildGraph(dict);

		// System.out.println(graph);

		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		queue.offer(start);

		int level = 1;
		while (!queue.isEmpty()) {

			int size = queue.size();
			level++;

			for (int i = 0; i < size; i++) {
				String tmp = queue.poll();

				for (String str : graph.get(tmp)) {
					if (str.equals(end)) {
						return level;
					}
					if (!visited.contains(str)) {
						queue.offer(str);
						visited.add(str);
					}
				}

			}

		}

		return -1;
	}

	private Map<String, Set<String>> buildGraph(Set<String> dict) {

		Map<String, Set<String>> graph = new HashMap<>();

		for (String str1 : dict) {
			graph.put(str1, new HashSet<String>());
			for (String str2 : dict) {
				if (!str1.equals(str2) && isNext(str1, str2)) {
					graph.get(str1).add(str2);
				}

			}
		}

		return graph;
	}

	private boolean isNext(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return true;
	}
}

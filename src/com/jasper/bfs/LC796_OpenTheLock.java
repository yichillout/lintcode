package com.jasper.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC796_OpenTheLock {

	public int openLock(String[] deadends, String target) {

		String start = "0000";

		Set<String> deadset = new HashSet<>();

		for (String deadend : deadends) {
			if (deadend.equals(start)) {
				return -1;
			}
			deadset.add(deadend);
		}

		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		q.offer(start);
		visited.add(start);

		int step = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String cur = q.poll();
				if (cur.equals(target)) {
					return step;
				}

				for (int j = 0; j < 4; j++) {
					String next = cur.substring(0, j) + (char) ((cur.charAt(j) - '0' + 9) % 10 + '0')
							+ cur.substring(j + 1);
					if (!visited.contains(next) && !deadset.contains(next)) {
						q.offer(next);
						visited.add(next);
					}
					next = cur.substring(0, j) + (char) ((cur.charAt(j) - '0' + 1) % 10 + '0') + cur.substring(j + 1);
					if (!visited.contains(next) && !deadset.contains(next)) {
						q.offer(next);
						visited.add(next);
					}
				}
			}
			step++;
		}

		return -1;
	}
}

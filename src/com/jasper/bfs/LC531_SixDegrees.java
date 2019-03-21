package com.jasper.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC531_SixDegrees {

	// Solution 1
	public int sixDegrees1(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {

		Set<UndirectedGraphNode> visited = new HashSet<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();

		if (s == t)
			return 0;

		queue.offer(s);
		visited.add(s);

		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			for (int i = 0; i < size; i++) {
				UndirectedGraphNode node = queue.poll();
				for (UndirectedGraphNode next : node.neighbors) {
					if (!visited.contains(next)) {
						if (next == t) {
							return level;
						}
						queue.offer(next);
						visited.add(next);
					}
				}
			}
		}
		return -1;
	}

	// Solution 2
	public int sixDegrees2(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {

		if (s == t)
			return 0;

		Map<UndirectedGraphNode, Integer> visited = new HashMap<UndirectedGraphNode, Integer>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

		queue.offer(s);
		visited.put(s, 0);

		while (!queue.isEmpty()) {
			UndirectedGraphNode node = queue.poll();
			int step = visited.get(node);
			for (int i = 0; i < node.neighbors.size(); i++) {
				if (visited.containsKey(node.neighbors.get(i))) {
					continue;
				}
				visited.put(node.neighbors.get(i), step + 1);
				queue.offer(node.neighbors.get(i));
				if (node.neighbors.get(i) == t) {
					return step + 1;
				}
			}
		}

		return -1;
	}
}

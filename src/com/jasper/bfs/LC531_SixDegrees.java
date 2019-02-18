package com.jasper.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC531_SixDegrees {

	public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {

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

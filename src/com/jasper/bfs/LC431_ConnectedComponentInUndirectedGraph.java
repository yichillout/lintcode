package com.jasper.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC431_ConnectedComponentInUndirectedGraph {

	public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
		// Write your code here

		Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();

		for (UndirectedGraphNode node : nodes) {
			visited.put(node, false);
		}

		List<List<Integer>> result = new ArrayList<>();

		for (UndirectedGraphNode node : nodes) {
			if (visited.get(node) == false) {
				bfs(node, visited, result);
			}
		}

		return result;
	}

	public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> result) {
		List<Integer> row = new ArrayList<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();

		queue.offer(node);
		visited.put(node, true);

		while (!queue.isEmpty()) {
			UndirectedGraphNode u = queue.poll();
			row.add(u.label);
			for (UndirectedGraphNode v : u.neighbors) {
				if (visited.get(v) == false) {
					visited.put(v, true);
					queue.offer(v);
				}
			}
		}

		Collections.sort(row);
		result.add(row);
	}
}

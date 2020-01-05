package com.jasper.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.jasper.annotation.ImportantExample;
import com.jasper.annotation.Template;

@Template
@ImportantExample
public class LC431_ConnectedComponentInUndirectedGraph {

	// solution 1: BFS
	public List<List<Integer>> connectedSet1(List<UndirectedGraphNode> nodes) {

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

	// solution 2: union find
	class UnionFind {
		Map<Integer, Integer> map;

		public UnionFind(List<UndirectedGraphNode> nodes) {
			map = new HashMap<>();
			for (int i = 0; i < nodes.size(); i++) {
				map.put(nodes.get(i).label, nodes.get(i).label);
			}
		}

		public void union(int id1, int id2) {
			int p1 = find(id1);
			int p2 = find(id2);
			if (p1 == p2)
				return;
			map.put(p1, p2);
		}

		public int find(int id) {
			if (map.get(id) != id) {
				map.put(id, find(map.get(id)));
			}
			return map.get(id);
		}
	}

	public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
		UnionFind uf = new UnionFind(nodes);

		for (int i = 0; i < nodes.size(); i++) {
			UndirectedGraphNode node = nodes.get(i);
			for (int j = 0; j < node.neighbors.size(); j++) {
				UndirectedGraphNode neighbor = node.neighbors.get(j);
				uf.union(node.label, neighbor.label);
			}
		}

		Map<Integer, List<Integer>> hm = new HashMap<>();

		for (Map.Entry<Integer, Integer> entry : uf.map.entrySet()) {
			int number = uf.find(entry.getKey());
			if (!hm.containsKey(number)) {
				hm.put(number, new ArrayList<>());
			}
			hm.get(number).add(entry.getKey());
		}

		for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
			Collections.sort(entry.getValue());
		}

		List<List<Integer>> result = new ArrayList<List<Integer>>(hm.values());

		return result;
	}
}

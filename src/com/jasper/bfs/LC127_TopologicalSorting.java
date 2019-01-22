package com.jasper.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};

public class LC127_TopologicalSorting {

	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		ArrayList<DirectedGraphNode> order = new ArrayList<DirectedGraphNode>();

		// count indegree
		Map<DirectedGraphNode, Integer> map = getIndegree(graph);

		// topological sorting - bfs
		List<DirectedGraphNode> nodes = getStartNodes(map, graph);
		order = bfs(map, nodes);

		// in case of cycle
		if (order.size() == graph.size()) {
			return order;
		}

		return null;
	}

	private List<DirectedGraphNode> getStartNodes(Map<DirectedGraphNode, Integer> map,
			ArrayList<DirectedGraphNode> graph) {
		List<DirectedGraphNode> nodes = new ArrayList<DirectedGraphNode>();
		for (DirectedGraphNode node : graph) {
			if (map.get(node) == 0) {
				nodes.add(node);
			}
		}
		return nodes;
	}

	private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
		Map<DirectedGraphNode, Integer> map = new HashMap<>();
		for (DirectedGraphNode node : graph) {
			map.put(node, 0);
		}

		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode neighbor : node.neighbors) {
				map.put(neighbor, map.get(neighbor) + 1);
			}
		}
		return map;
	}

	private ArrayList<DirectedGraphNode> bfs(Map<DirectedGraphNode, Integer> map, List<DirectedGraphNode> nodes) {
		ArrayList<DirectedGraphNode> order = new ArrayList<>();
		Queue<DirectedGraphNode> queue = new LinkedList<>();

		for (DirectedGraphNode node : nodes) {
			order.add(node);
			queue.offer(node);
		}

		while (!queue.isEmpty()) {
			DirectedGraphNode node = queue.poll();
			for (DirectedGraphNode neighbor : node.neighbors) {
				map.put(neighbor, map.get(neighbor) - 1);
				if (map.get(neighbor) == 0) {
					queue.offer(neighbor);
					order.add(neighbor);
				}
			}
		}

		return order;
	}

}

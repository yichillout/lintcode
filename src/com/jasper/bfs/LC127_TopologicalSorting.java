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

		Map<DirectedGraphNode, Integer> inDegrees = getInDegrees(graph);
		Queue<DirectedGraphNode> queue = new LinkedList<>();
		ArrayList<DirectedGraphNode> list = new ArrayList<>();

		for (DirectedGraphNode graphNode : inDegrees.keySet()) {
			if (inDegrees.get(graphNode) == 0) {
				queue.offer(graphNode);
				list.add(graphNode);
			}
		}

		while (!queue.isEmpty()) {
			DirectedGraphNode tmp = queue.poll();
			for (DirectedGraphNode neighbor : tmp.neighbors) {
				inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);
				if (inDegrees.get(neighbor) == 0) {
					queue.offer(neighbor);
					list.add(neighbor);
				}
			}
		}

		if (list.size() != graph.size())
			return null;

		return list;
	}

	private Map<DirectedGraphNode, Integer> getInDegrees(ArrayList<DirectedGraphNode> graph) {
		Map<DirectedGraphNode, Integer> inDegrees = new HashMap<>();

		for (DirectedGraphNode graphNode : graph) {
			inDegrees.put(graphNode, 0);
		}

		for (DirectedGraphNode graphNode : graph) {
			for (DirectedGraphNode neighbor : graphNode.neighbors) {
				inDegrees.put(neighbor, inDegrees.get(neighbor) + 1);
			}
		}
		return inDegrees;
	}
}

package com.jasper.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC618_SearchGraphNodes {

	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
			Map<UndirectedGraphNode, Integer> values, UndirectedGraphNode node, int target) {

		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();

		queue.offer(node);
		hash.add(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode head = queue.poll();
			if (values.get(head) == target) {
				return head;
			}
			for (UndirectedGraphNode nei : head.neighbors) {
				if (!hash.contains(nei)) {
					queue.offer(nei);
					hash.add(nei);
				}
			}
		}
		return null;
	}

}

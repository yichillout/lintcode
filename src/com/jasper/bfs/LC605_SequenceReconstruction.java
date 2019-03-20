package com.jasper.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC605_SequenceReconstruction {

	public boolean sequenceReconstruction(int[] org, int[][] seqs) {

		Map<Integer, Set<Integer>> graph = build(seqs);
		Map<Integer, Integer> inDegrees = getInDegrees(seqs, graph);

		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		for (int key : inDegrees.keySet()) {
			if (inDegrees.get(key) == 0) {
				queue.offer(key);
				result.add(key);
			}
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			if (size > 1) {
				return false;
			}
			int num = queue.poll();

			// in case of NullPointerException
			// when buiding the graph, some of the number is not put into the graph
			if (!graph.containsKey(num)) {
				continue;
			}

			for (int next : graph.get(num)) {
				inDegrees.put(next, inDegrees.get(next) - 1);
				if (inDegrees.get(next) == 0) {
					queue.offer(next);
					result.add(next);
				}
			}
		}

		if (result.size() != org.length) {
			return false;
		}
		for (int i = 0; i < org.length; i++) {
			if (org[i] != result.get(i)) {
				return false;
			}
		}
		return true;
	}

	private Map<Integer, Integer> getInDegrees(int[][] seqs, Map<Integer, Set<Integer>> graph) {
		Map<Integer, Integer> inDegrees = new HashMap<>();
		for (int i = 0; i < seqs.length; i++) {
			for (int j = 0; j < seqs[i].length; j++) {
				inDegrees.put(seqs[i][j], 0);
			}
		}

		for (int key : graph.keySet()) {
			for (int next : graph.get(key)) {
				inDegrees.put(next, inDegrees.get(next) + 1);
			}
		}
		return inDegrees;
	}

	private Map<Integer, Set<Integer>> build(int[][] seqs) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < seqs.length; i++) {
			for (int j = 0; j < seqs[i].length - 1; j++) {
				int num1 = seqs[i][j];
				int num2 = seqs[i][j + 1];
				if (!graph.containsKey(num1)) {
					graph.put(num1, new HashSet<Integer>());
					graph.get(num1).add(num2);
				} else {
					graph.get(num1).add(num2);
				}
			}
		}
		return graph;
	}
}

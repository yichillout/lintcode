package com.jasper.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC178_GraphValidTree {

	// Solution 1 : BFS
	public static boolean validTree1(int n, int[][] edges) {
		if (n == 0) {
			return false;
		}

		if (edges.length != n - 1) {
			return false;
		}

		Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);

		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> hash = new HashSet<>();

		queue.offer(0);
		hash.add(0);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (Integer neighbor : graph.get(node)) {
				if (hash.contains(neighbor)) {
					continue;
				}
				hash.add(neighbor);
				queue.offer(neighbor);
			}
		}

		return (hash.size() == n);
	}

	private static Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		return graph;
	}

	// Solution 2 : Union Find
	class UnionFind {

		Map<Integer, Integer> parents;

		public UnionFind(int n) {
			parents = new HashMap<Integer, Integer>();
			for (int i = 0; i < n; i++) {
				parents.put(i, i);
			}
		}

		public void union(int n1, int n2) {
			int p1 = find(n1);
			int p2 = find(n2);

			if (p1 == p2)
				return;

			parents.put(p1, p2);
		}

		public int find(int n) {
			if (parents.get(n) != n) {
				parents.put(n, find(parents.get(n)));
			}
			return parents.get(n);
		}

	}

	public boolean validTree2(int n, int[][] edges) {

		if (n - 1 != edges.length) {
			return false;
		}

		UnionFind uf = new UnionFind(n);

		for (int[] edge : edges) {
			int p1 = uf.find(edge[0]);
			int p2 = uf.find(edge[1]);
			if (p1 == p2) {
				return false;
			}
			uf.union(edge[0], edge[1]);
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		System.out.println(validTree1(5, edges));
	}
}

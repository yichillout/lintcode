package com.jasper.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC178_GraphValidTree {

	// Solution 1 : BFS
	public boolean validTree1(int n, int[][] edges) {
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

	private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
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
		HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

		UnionFind(int n) {
			for (int i = 0; i < n; i++) {
				father.put(i, i);
			}
		}

		int compressed_find(int x) {
			int parent = father.get(x);
			while (parent != father.get(parent)) {
				parent = father.get(parent);
			}
			int temp = -1;
			int fa = father.get(x);
			while (fa != father.get(fa)) {
				temp = father.get(fa);
				father.put(fa, parent);
				fa = temp;
			}
			return parent;

		}

		void union(int x, int y) {
			int fa_x = compressed_find(x);
			int fa_y = compressed_find(y);
			if (fa_x != fa_y)
				father.put(fa_x, fa_y);
		}
	}

	public boolean validTree2(int n, int[][] edges) {
		// tree should have n nodes with n-1 edges
		if (n - 1 != edges.length) {
			return false;
		}

		UnionFind uf = new UnionFind(n);

		for (int i = 0; i < edges.length; i++) {
			if (uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1])) {
				return false;
			}
			uf.union(edges[i][0], edges[i][1]);
		}
		return true;
	}
}

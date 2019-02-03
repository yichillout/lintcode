package com.jasper.unionfind;

/* 
 * Description
 * Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.
 *
 * You need to support the following method:
 * 1. connect(a, b), add an edge to connect node a and node b.
 * 2. query(a), Returns the number of connected component nodes which include node a.
 *
 * Example
 * 5 // n = 5
 * query(1) return 1
 * connect(1, 2)
 * query(1) return 2
 * connect(2, 4)
 * query(1) return 3
 * connect(1, 4)
 * query(1) return 3
 */

public class LC590_ConnectingGraphII {
	private int[] father = null;
	private int[] size = null;

	private int find(int x) {
		int j, k, fx;
		j = x;
		while (father[j] != j) {
			j = father[j];
		}

		while (x != j) {
			fx = father[x];
			father[x] = j;
			x = fx;
		}

		return j;
	}

	public LC590_ConnectingGraphII(int n) {
		// initialize your data structure here.
		father = new int[n + 1];
		size = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			father[i] = i;
			size[i] = 1;
		}
	}

	public void connect(int a, int b) {
		// Write your code here
		int root_a = find(a);
		int root_b = find(b);
		if (root_a != root_b) {
			father[root_a] = root_b;
			size[root_b] += size[root_a];
		}
	}

	public int query(int a) {
		// Write your code here
		int root_a = find(a);
		return size[root_a];
	}
}

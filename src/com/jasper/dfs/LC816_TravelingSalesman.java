package com.jasper.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC816_TravelingSalesman {

	class Pair implements Comparable<Pair> {
		int cur, remaining, cost;
		boolean[] visited;

		Pair(int cur, int remaining, int cost, boolean[] visited) {
			this.cur = cur;
			this.remaining = remaining;
			this.cost = cost;
			this.visited = Arrays.copyOf(visited, visited.length);
			this.visited[cur] = true;
		}

		public int compareTo(Pair other) {
			return this.cost - other.cost;
		}
	}

	public int minCost(int n, int[][] roads) {
		if (roads == null || roads.length == 0 || n <= 1)
			return 0;

		Map<Integer, List<int[]>> srcToDesMap = getSrcToDesMap(roads);

		Queue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, n - 1, 0, new boolean[n + 1]));

		while (!pq.isEmpty()) {
			Pair curPos = pq.poll();
			if (curPos.remaining == 0)
				return curPos.cost;

			for (int[] next : srcToDesMap.get(curPos.cur)) {
				if (curPos.visited[next[0]])
					continue;

				pq.offer(new Pair(next[0], curPos.remaining - 1, curPos.cost + next[1], curPos.visited));
			}
		}
		return 0;
	}

	private Map<Integer, List<int[]>> getSrcToDesMap(int[][] roads) {
		Map<Integer, List<int[]>> result = new HashMap<>();
		for (int[] road : roads) {
			int c1 = road[0], c2 = road[1], cost = road[2];
			result.putIfAbsent(c1, new ArrayList<>());
			result.get(c1).add(new int[] { c2, cost });

			result.putIfAbsent(c2, new ArrayList<>());
			result.get(c2).add(new int[] { c1, cost });
		}

		return result;
	}

}

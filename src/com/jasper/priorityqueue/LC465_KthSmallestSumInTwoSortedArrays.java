package com.jasper.priorityqueue;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LC465_KthSmallestSumInTwoSortedArrays {

	private class Pair {
		public int x, y, sum;

		public Pair(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.sum = val;
		}
	}

	class PairComparator implements Comparator<Pair> {
		public int compare(Pair a, Pair b) {
			return a.sum - b.sum;
		}
	}

	// Solution 1
	public int kthSmallestSum1(int[] A, int[] B, int k) {
		int[] dx = new int[] { 0, 1 };
		int[] dy = new int[] { 1, 0 };
		boolean[][] hash = new boolean[A.length][B.length];
		PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
		minHeap.add(new Pair(0, 0, A[0] + B[0]));

		for (int i = 0; i < k - 1; i++) {
			Pair cur = minHeap.poll();
			for (int j = 0; j < 2; j++) {
				int next_x = cur.x + dx[j];
				int next_y = cur.y + dy[j];
				Pair next_Pair = new Pair(next_x, next_y, 0);
				if (next_x < A.length && next_y < B.length && !hash[next_x][next_y]) {
					hash[next_x][next_y] = true;
					next_Pair.sum = A[next_x] + B[next_y];
					minHeap.add(next_Pair);
				}
			}
		}
		return minHeap.peek().sum;
	}

	private class Pair2 implements Comparable<Pair> {
		int x;
		int y;
		int sum;

		Pair2(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public int compareTo(Pair another) {
			if (this.sum == another.sum) {
				return 0;
			}
			return this.sum < another.sum ? -1 : 1;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!(obj instanceof Pair)) {
				return false;
			}
			Pair another = (Pair) obj;
			return this.x == another.x && this.y == another.y;
		}

		@Override
		public int hashCode() {
			return x * 101 + y;
		}
	}

	// Solution 2
	int[] dx = { 1, 0 };
	int[] dy = { 0, 1 };

	public int kthSmallestSum2(int[] A, int[] B, int k) {
		if (A.length == 0 && B.length == 0) {
			return 0;
		} else if (A.length == 0) {
			return B[k];
		} else if (B.length == 0) {
			return A[k];
		}
		HashSet<Pair2> isVisited = new HashSet<Pair2>();
		PriorityQueue<Pair2> minHeap = new PriorityQueue<Pair2>();
		Pair2 p;
		Pair2 nextP;
		p = new Pair2(0, 0, A[0] + B[0]);
		minHeap.offer(p);
		isVisited.add(p);
		int nextX;
		int nextY;
		int nextSum;
		for (int count = 0; count < k - 1; count++) {
			p = minHeap.poll();
			for (int i = 0; i < 2; i++) {
				nextX = p.x + dx[i];
				nextY = p.y + dy[i];
				nextP = new Pair2(nextX, nextY, 0);
				if (nextX >= 0 && nextX < A.length && nextY >= 0 && nextY < B.length && !isVisited.contains(nextP)) {
					nextSum = A[nextX] + B[nextY];
					nextP.sum = nextSum;
					minHeap.offer(nextP);
					isVisited.add(nextP);
				}
			}
		}
		return minHeap.peek().sum;
	}
}
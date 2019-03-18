package com.jasper.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Description
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). Originally, the 2D matrix is 
 * all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, 
 * A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there 
 * in the matrix after each operator.
 * 
 * Notice
 * 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 * 
 * Example
 * Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
 * 
 * return [1,1,2,2].
 */

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}
}

public class LC434_NumberOfIslandsII {

	int converttoId(int row, int col, int m) {
		return row * m + col;
	}

	class UnionFind {
		HashMap<Integer, Integer> parents = new HashMap<Integer, Integer>();

		UnionFind(int n, int m) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int id = converttoId(i, j, m);
					parents.put(id, id);
				}
			}
		}

		int find(int id) {
			if (parents.get(id) != id) {
				parents.put(id, find(parents.get(id)));
			}
			return parents.get(id);
		}

		void union(int id1, int id2) {
			int p1 = find(id1);
			int p2 = find(id2);
			if (p1 != p2)
				parents.put(p1, p2);
		}
	}

	public List<Integer> numIslands2(int n, int m, Point[] operators) {

		List<Integer> results = new ArrayList<Integer>();
		if (operators == null) {
			return results;
		}

		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		int[][] island = new int[n][m];

		UnionFind uf = new UnionFind(n, m);
		int count = 0;

		for (int i = 0; i < operators.length; i++) {
			int x = operators[i].x;
			int y = operators[i].y;
			if (island[x][y] == 0) {
				count++;
				island[x][y] = 1;
				for (int j = 0; j < 4; j++) {
					int xx = x + dir[j][0];
					int yy = y + dir[j][1];
					if (0 <= xx && xx < n && 0 <= yy && yy < m && island[xx][yy] == 1) {
						int id1 = converttoId(x, y, m);
						int id2 = converttoId(xx, yy, m);
						int p1 = uf.find(id1);
						int p2 = uf.find(id2);
						if (p1 != p2) {
							count--;
							uf.union(id1, id2);
						}
					}
				}
			}
			results.add(count);
		}
		return results;
	}
}

package com.jasper.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x;
	int y;

	public Point() {
		this(0, 0);
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class LC611_KnightShortestPath {

	public int shortestPath(boolean[][] grid, Point source, Point destination) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}

		int[][] dir = { { 1, 2 }, { 1, -2 }, { 2, 1 }, { 2, -1 }, { -1, 2 }, { -1, -2 }, { -2, 1 }, { -2, -1 } };

		Queue<Point> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[grid.length][grid[0].length]; // Set<Point> v will TLE

		q.offer(source);
		isVisited[source.x][source.y] = true;

		if (source.x == destination.x && source.y == destination.y) {
			return 0;
		}

		int dist = 0;

		while (!q.isEmpty()) {
			dist++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point cur = q.poll();
				for (int k = 0; k < 8; k++) {
					int xx = cur.x + dir[k][0];
					int yy = cur.y + dir[k][1];
					if (0 <= xx && xx < grid.length && 0 <= yy && yy < grid[0].length && !grid[xx][yy]
							&& !isVisited[xx][yy]) {
						if (xx == destination.x && yy == destination.y) {
							return dist;
						}
						q.offer(new Point(xx, yy));
						isVisited[xx][yy] = true;
					}
				}
			}

		}
		return -1;
	}
}

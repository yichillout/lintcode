package com.jasper.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC573_BuildPostOfficeII {

	public int shortestDistance(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					result = Math.min(result, bfs(grid, i, j));
				}
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private int bfs(int[][] grid, int row, int col) {

		Queue<int[]> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[grid.length][grid[0].length];
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		q.offer(new int[] { row, col });
		isVisited[row][col] = true;

		int distance = 0;
		int sum = 0;

		while (!q.isEmpty()) {

			distance++;
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];
				for (int k = 0; k < 4; k++) {
					int xx = x + dir[k][0];
					int yy = y + dir[k][1];
					if (0 <= xx && xx < grid.length && 0 <= yy && yy < grid[0].length && !isVisited[xx][yy]) {
						isVisited[xx][yy] = true;

						if (grid[xx][yy] == 1) {
							sum += distance;
						}
						if (grid[xx][yy] == 0) {
							q.offer(new int[] { xx, yy });
						}
					}
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && !isVisited[i][j]) {
					return Integer.MAX_VALUE;
				}
			}
		}
		return sum;
	}

}

package com.jasper.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC433_NumberOfIslands {

	public int numIslands(boolean[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int counter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j]) {
					bfs(grid, i, j);
					counter++;
				}
			}
		}

		return counter;
	}

	private void bfs(boolean[][] grid, int x, int y) {

		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { x, y });
		grid[x][y] = false;

		int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		while (!q.isEmpty()) {

			int[] point = q.poll();

			for (int i = 0; i < 4; i++) {
				int xx = point[0] + dir[i][0];
				int yy = point[1] + dir[i][1];
				if (xx < grid.length && xx >= 0 && yy < grid[0].length && yy >= 0 && grid[xx][yy]) {
					q.offer(new int[] { xx, yy });
					grid[xx][yy] = false;
				}
			}

		}

	}

}

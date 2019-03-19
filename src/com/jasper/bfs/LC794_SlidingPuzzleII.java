package com.jasper.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC794_SlidingPuzzleII {

	public int minMoveStep(int[][] init_state, int[][] final_state) {

		String source = matrixToString(init_state);
		String target = matrixToString(final_state);

		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		queue.offer(source);
		visited.add(source);

		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(target)) {
					return step;
				}

				for (String next : getNext(cur)) {
					if (visited.contains(next)) {
						continue;
					}
					queue.offer(next);
					visited.add(next);
				}
			}
			step++;
		}

		return -1;
	}

	public String matrixToString(int[][] state) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(state[i][j]);
			}
		}
		return sb.toString();
	}

	public List<String> getNext(String state) {
		List<String> states = new ArrayList<>();
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		int zeroIndex = state.indexOf('0');
		int x = zeroIndex / 3;
		int y = zeroIndex % 3;

		for (int i = 0; i < 4; i++) {
			int xx = x + dir[i][0];
			int yy = y + dir[i][1];
			if (xx < 0 || xx >= 3 || yy < 0 || yy >= 3) {
				continue;
			}

			char[] chars = state.toCharArray();
			chars[x * 3 + y] = chars[xx * 3 + yy];
			chars[xx * 3 + yy] = '0';
			states.add(new String(chars));
		}

		return states;
	}

}

package com.jasper.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC121_WordLadderII {

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

		List<List<String>> result = new ArrayList<>();
		Map<String, Integer> distance = new HashMap<>(); // 这里的distance还有标记是否走过的作用
		Map<String, List<String>> map = new HashMap<>();

		wordList.add(beginWord);
		wordList.add(endWord);

		bfs(map, distance, endWord, wordList);

		List<String> path = new ArrayList<String>();
		dfs(result, path, map, distance, beginWord, endWord, wordList);

		return result;
	}

	private void dfs(List<List<String>> result, List<String> path, Map<String, List<String>> map,
			Map<String, Integer> distance, String start, String endWord, Set<String> wordList) {

		path.add(start);

		if (start.equals(endWord)) {
			result.add(new ArrayList<String>(path));
			path.remove(path.size() - 1);
			return;
		}

		for (String neighbor : map.get(start)) {
			if (distance.containsKey(neighbor) && distance.get(neighbor) + 1 == distance.get(start)) {
				dfs(result, path, map, distance, neighbor, endWord, wordList);
			}
		}

		path.remove(path.size() - 1);
	}

	private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String endWord,
			Set<String> wordList) {

		Queue<String> q = new LinkedList<>();

		for (String str : wordList) {
			map.put(str, new ArrayList<String>());
		}

		int level = 0;

		q.offer(endWord);
		distance.put(endWord, level);

		while (!q.isEmpty()) {

			int size = q.size();
			level++;

			for (int i = 0; i < size; i++) {
				String tmp = q.poll();
				for (String str : wordList) {
					if (isNeighbors(tmp, str)) {
						map.get(str).add(tmp);
						if (!distance.containsKey(str)) {
							q.offer(str);
							distance.put(str, level);
						}
					}
				}
			}
		}

	}

	private boolean isNeighbors(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return count == 1;
	}
}

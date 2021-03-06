package com.jasper.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC616_CourseScheduleII {

	// Solution 1
	public int[] findOrder1(int numCourses, int[][] prerequisites) {

		List[] edges = new ArrayList[numCourses];
		int[] degree = new int[numCourses];

		for (int i = 0; i < numCourses; i++)
			edges[i] = new ArrayList<Integer>();

		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][0]]++;
			edges[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		Queue queue = new LinkedList();
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;
		int[] order = new int[numCourses];
		while (!queue.isEmpty()) {
			int course = (int) queue.poll();
			order[count] = course;
			count++;
			int n = edges[course].size();
			for (int i = n - 1; i >= 0; i--) {
				int pointer = (int) edges[course].get(i);
				degree[pointer]--;
				if (degree[pointer] == 0) {
					queue.add(pointer);
				}
			}
		}

		if (count == numCourses)
			return order;

		return new int[0];
	}

	// Solution 2
	public int[] findOrder2(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> courses = new HashMap<>();
		Map<Integer, Integer> indegree = new HashMap<>();
		int[] results = new int[numCourses];

		courses = build(numCourses, prerequisites);
		indegree = getIndegree(numCourses, prerequisites);

		Queue<Integer> queue = new LinkedList<>();

		int index = 0;
		int count = 0;
		for (Integer key : indegree.keySet()) {
			if (indegree.get(key) == 0) {
				queue.offer(key);
				results[index++] = key;
				count++;
			}
		}

		while (!queue.isEmpty()) {
			int course = queue.poll();
			List<Integer> list = courses.get(course);
			for (int i = 0; i < list.size(); i++) {
				indegree.put(list.get(i), indegree.get(list.get(i)) - 1);
				if (indegree.get(list.get(i)) == 0) {
					queue.offer(list.get(i));
					results[index++] = list.get(i);
					count++;
				}
			}
		}

		if (count != numCourses)
			return new int[0];

		return results;
	}

	private Map<Integer, List<Integer>> build(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> courses = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			courses.put(i, new ArrayList<Integer>());
		}
		for (int[] pre : prerequisites) {
			courses.get(pre[1]).add(pre[0]);
		}
		return courses;
	}

	private Map<Integer, Integer> getIndegree(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> indegree = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			indegree.put(i, 0);
		}
		for (int[] pre : prerequisites) {
			indegree.put(pre[0], indegree.get(pre[0]) + 1);
		}
		return indegree;
	}

}

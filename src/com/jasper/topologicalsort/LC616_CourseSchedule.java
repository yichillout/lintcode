package com.jasper.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC616_CourseSchedule {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

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
}

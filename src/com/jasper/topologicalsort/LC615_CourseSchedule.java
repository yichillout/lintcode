package com.jasper.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC615_CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// 已知node和edge构造存储有向图图的map
		// 有了map之后，剩下的解法类似于topological sorting 那道题
		// 思路：1.把输入的参数转换成map形式存储的图
		// 2.拓扑排序得到list of result
		// 3.判断list中的节点个数是否为numCourses
		// 因为拓扑排序节点入度为0时才会存入result
		// 所以如果存在环，那么有向图的拓扑排序节点个数就会小于图的节点个数
		
		if (numCourses == 0 || prerequisites.length == 0) {
			return true;
		}

		HashMap<Integer, List<Integer>> courseMap = creatCourseMap(numCourses, prerequisites);
		
		HashMap<Integer, Integer> indegreeMap = new HashMap<>();
		
		for (int i = 0; i < numCourses; i++) {
			for (Integer neighbor : courseMap.get(i)) {
				if (indegreeMap.containsKey(neighbor)) {
					indegreeMap.put(neighbor, indegreeMap.get(neighbor) + 1);
				} else {
					indegreeMap.put(neighbor, 1);
				}
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			if (!indegreeMap.containsKey(i)) {
				queue.offer(i);
				result.add(i);
			}
		}

		while (!queue.isEmpty()) {
			Integer course = queue.poll();
			for (Integer neighbor : courseMap.get(course)) {
				indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);
				
				if (indegreeMap.get(neighbor) == 0) {
					queue.offer(neighbor);
					result.add(neighbor);
				}
			}
		}
		
		return result.size() == numCourses;
	}

	// 创建courseMap有向图,方向为先修课程指向当前课程pre -> cur
	private HashMap<Integer, List<Integer>> creatCourseMap(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int cur = prerequisites[i][0];
			int pre = prerequisites[i][1];
			map.get(pre).add(cur);
		}
		return map;
	}
}

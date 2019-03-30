package com.jasper.divideconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jasper.dfs.TreeNode;

public class LC650_FindLeavesOfBinaryTree {

	public List<List<Integer>> findLeaves(TreeNode root) {

		Map<Integer, List<Integer>> map = new HashMap<>();
		List<List<Integer>> results = new ArrayList<>();

		int treeHeight = helper(root, map);

		for (int i = 1; i <= treeHeight; i++) {
			results.add(map.get(i));
		}

		return results;
	}

	private int helper(TreeNode node, Map<Integer, List<Integer>> map) {

		if (node == null)
			return 0;

		int left = helper(node.left, map);
		int right = helper(node.right, map);

		int height = Math.max(left, right) + 1;

		if (!map.containsKey(height)) {
			map.put(height, new ArrayList<Integer>());
		}

		map.get(height).add(node.val);

		return height;
	}

}

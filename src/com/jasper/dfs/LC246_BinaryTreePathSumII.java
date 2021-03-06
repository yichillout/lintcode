package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC246_BinaryTreePathSumII {

	public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		if (root == null)
			return results;
		findSum(root, target, buffer, 0, results);
		return results;
	}

	public void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level, List<List<Integer>> results) {

		if (head == null)
			return;

		int tmp = sum;

		buffer.add(head.val);

		// from the end node to root
		for (int i = level; i >= 0; i--) {
			tmp -= buffer.get(i);
			if (tmp == 0) {
				List<Integer> temp = new ArrayList<Integer>();
				for (int j = i; j <= level; ++j)
					temp.add(buffer.get(j));
				results.add(temp);
			}
		}

		findSum(head.left, sum, buffer, level + 1, results);
		findSum(head.right, sum, buffer, level + 1, results);

		buffer.remove(buffer.size() - 1);
	}
}

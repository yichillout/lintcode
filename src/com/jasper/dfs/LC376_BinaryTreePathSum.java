package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC376_BinaryTreePathSum {

	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> buffer = new ArrayList<>();
		helper(results, buffer, root, target);
		return results;
	}

	private void helper(List<List<Integer>> results, List<Integer> buffer, TreeNode node, int remainingTarget) {

		if (node == null)
			return;

		buffer.add(node.val);
		remainingTarget = remainingTarget - node.val;

		if (remainingTarget == 0 && node.left == null && node.right == null) {
			results.add(new ArrayList<Integer>(buffer));
		}

		helper(results, buffer, node.left, remainingTarget);
		helper(results, buffer, node.right, remainingTarget);

		buffer.remove(buffer.size() - 1);
	}

}

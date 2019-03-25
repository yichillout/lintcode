package com.jasper.divideconquer;

import com.jasper.dfs.TreeNode;

public class LC596_MinimumSubtree {

	TreeNode subtree = null;
	int min = Integer.MAX_VALUE;

	public TreeNode findSubtree(TreeNode root) {
		helper(root);
		return subtree;
	}

	// 分治法通常会把返回统计的东西返回
	private int helper(TreeNode node) {
		if (node == null)
			return 0;

		int sum = node.val + helper(node.left) + helper(node.right);

		if (sum < min) {
			min = sum;
			subtree = node;
		}

		return sum;
	}

}

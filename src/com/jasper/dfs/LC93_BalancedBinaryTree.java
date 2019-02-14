package com.jasper.dfs;

public class LC93_BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;

		int left = height(root.left);
		int right = height(root.right);

		if (Math.abs(left - right) > 1)
			return false;

		return isBalanced(root.left) && isBalanced(root.right);
	}

	private int height(TreeNode node) {

		if (node == null)
			return 0;

		int left = height(node.left);
		int right = height(node.right);

		return 1 + Math.max(left, right);
	}

}

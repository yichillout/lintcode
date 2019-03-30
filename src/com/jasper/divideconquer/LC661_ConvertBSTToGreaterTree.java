package com.jasper.divideconquer;

import com.jasper.dfs.TreeNode;

public class LC661_ConvertBSTToGreaterTree {
	int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		dfs(root);
		return root;
	}

	private void dfs(TreeNode node) {
		if (node == null)
			return;
		dfs(node.right);
		sum += node.val;
		node.val = sum;
		dfs(node.left);
	}
}

package com.jasper.dfs;

public class LC85_InsertNodeInBinarySearchTree {

	public TreeNode insertNode(TreeNode root, TreeNode node) {

		if (root == null) {
			return node;
		}

		if (root.val > node.val) {
			root.left = insertNode(root.left, node);
		} else {
			root.right = insertNode(root.right, node);
		}

		return root;
	}

}

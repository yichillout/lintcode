package com.jasper.dfs;

import java.util.Stack;

public class LC448_InorderSuccessorInBST {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

		Stack<TreeNode> stack = new Stack<>();

		if (root == null)
			return null;

		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		boolean isNode = false;

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			if (isNode == true)
				return node;

			if (node == p)
				isNode = true;

			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}

		}

		return null;
	}
}

package com.jasper.tree;

import java.util.Stack;

import com.jasper.dfs.TreeNode;

public class LC175_InvertBinaryTree {

	// Solution 1
	public void invertBinaryTree1(TreeNode root) {

		Stack<TreeNode> st = new Stack<TreeNode>();

		while (root != null || !st.isEmpty()) {
			while (root != null) {
				st.push(root);
				root = root.left;
			}

			root = st.pop();

			TreeNode tmp = root.right;
			root.right = root.left;
			root.left = tmp;

			root = root.left;
		}
	}

	// Solution 2
	public void invertBinaryTree2(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertBinaryTree2(root.left);
		invertBinaryTree2(root.right);
	}
}

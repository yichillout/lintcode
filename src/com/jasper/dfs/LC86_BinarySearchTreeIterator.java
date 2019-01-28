package com.jasper.dfs;

import java.util.Stack;

public class LC86_BinarySearchTreeIterator {
	
	// 这个stack存储的是从这个节点到root的路径
	private Stack<TreeNode> stack = new Stack<>();

	// @param root: The root of binary tree.
	public LC86_BinarySearchTreeIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	// @return: True if there has next node, or false
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	// @return: return next node
	public TreeNode next() {
		TreeNode curt = stack.peek();
		TreeNode node = curt;

		// 网上找右拐点
		if (node.right == null) {
			node = stack.pop();
			while (!stack.isEmpty() && stack.peek().right == node) {
				node = stack.pop();
			}
		} else {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}

		return curt;
	}
}

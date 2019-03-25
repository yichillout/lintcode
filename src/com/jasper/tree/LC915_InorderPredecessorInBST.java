package com.jasper.tree;

import java.util.Stack;

import com.jasper.dfs.TreeNode;

public class LC915_InorderPredecessorInBST {

	public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {

		Stack<TreeNode> stack = new Stack();

		TreeNode cur = root;
		TreeNode pre = null;
		TreeNode result = null;

		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		while (!stack.isEmpty()) {
			cur = stack.pop();

			if (cur == p) {
				return pre;
			}

			pre = cur;

			if (cur.right != null) {
				cur = cur.right;
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
			}
		}

		return null;
	}

}

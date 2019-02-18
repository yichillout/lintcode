package com.jasper.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LC70_BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null)
			return res;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Stack<List<Integer>> stack = new Stack<>();

		q.add(root);

		while (!q.isEmpty()) {

			int size = q.size();
			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();

				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}

				list.add(node.val);
			}

			stack.push(list);
		}

		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}

		return res;

	}

}

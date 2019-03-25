package com.jasper.divideconquer;

import com.jasper.dfs.TreeNode;

public class LC595_BinaryTreeLongestConsecutiveSequence {

	// Solution 1 : Traverse + Divide Conquer
	public int longestConsecutive1(TreeNode root) {
		return helper(root, null, 0);
	}

	private int helper(TreeNode node, TreeNode parent, int lengthWithoutNode) {
		if (node == null)
			return 0;

		int length = 0;
		if (parent != null && parent.val + 1 == node.val) {
			length = lengthWithoutNode + 1;
		} else {
			length = 1;
		}

		int left = helper(node.left, node, length);
		int right = helper(node.right, node, length);

		return Math.max(length, Math.max(left, right));
	}

	// Solution 2 : Divide Conquer
	private class ResultType {
		int maxInSubtree;
		int maxFromRoot;

		public ResultType(int maxInSubtree, int maxFromRoot) {
			this.maxInSubtree = maxInSubtree;
			this.maxFromRoot = maxFromRoot;
		}
	}

	public int longestConsecutive2(TreeNode root) {
		return helper(root).maxInSubtree;
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, 0);
		}

		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		// 1 is the root itself.
		ResultType result = new ResultType(0, 1);

		if (root.left != null && root.val + 1 == root.left.val) {
			result.maxFromRoot = Math.max(result.maxFromRoot, left.maxFromRoot + 1);
		}

		if (root.right != null && root.val + 1 == root.right.val) {
			result.maxFromRoot = Math.max(result.maxFromRoot, right.maxFromRoot + 1);
		}

		result.maxInSubtree = Math.max(result.maxFromRoot, Math.max(left.maxInSubtree, right.maxInSubtree));

		return result;
	}

}

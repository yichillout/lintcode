package com.jasper.divideconquer;

import com.jasper.dfs.TreeNode;

public class LC628_MaximumSubtree {

	class RT {
		TreeNode maxNode;
		int sum;
		int max;

		public RT(TreeNode maxNode, int max, int sum) {
			this.maxNode = maxNode;
			this.max = max;
			this.sum = sum;
		}
	}

	public TreeNode findSubtree(TreeNode root) {
		return helper(root).maxNode;
	}

	private RT helper(TreeNode node) {
		if (node == null) {
			return new RT(null, Integer.MIN_VALUE, 0);
		}

		RT left = helper(node.left);
		RT right = helper(node.right);

		int sum = node.val + left.sum + right.sum;

		int max = sum;
		TreeNode maxNode = node;

		if (left.max > max) {
			max = left.max;
			maxNode = left.maxNode;
		}

		if (right.max > max) {
			max = right.max;
			maxNode = right.maxNode;
		}

		return new RT(maxNode, max, sum);
	}
}

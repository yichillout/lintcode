package com.jasper.divideconquer;

import com.jasper.dfs.TreeNode;

public class LC614_BinaryTreeLongestConsecutiveSequenceII {

	class ResultType {
		int maxLen;
		int upLen;
		int downLen;

		public ResultType(int maxLen, int upLen, int downLen) {
			this.maxLen = maxLen;
			this.upLen = upLen;
			this.downLen = downLen;
		}
	}

	public int longestConsecutive2(TreeNode root) {
		return helper(root).maxLen;
	}

	private ResultType helper(TreeNode node) {

		if (node == null)
			return new ResultType(0, 0, 0);

		ResultType left = helper(node.left);
		ResultType right = helper(node.right);

		int up = 0;
		int down = 0;

		if (node.left != null && node.val + 1 == node.left.val)
			up = Math.max(up, left.upLen + 1);

		if (node.left != null && node.val - 1 == node.left.val)
			down = Math.max(down, left.downLen + 1);

		if (node.right != null && node.val + 1 == node.right.val)
			up = Math.max(up, right.upLen + 1);

		if (node.right != null && node.val - 1 == node.right.val)
			down = Math.max(down, right.downLen + 1);

		int len = up + down + 1;
		len = Math.max(len, Math.max(left.maxLen, right.maxLen));

		return new ResultType(len, up, down);
	}

}

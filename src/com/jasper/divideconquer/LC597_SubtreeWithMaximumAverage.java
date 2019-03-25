package com.jasper.divideconquer;

import com.jasper.dfs.TreeNode;

public class LC597_SubtreeWithMaximumAverage {

	class ResultType {
		TreeNode node;
		int sum;
		int count;

		public ResultType(TreeNode node, int sum, int count) {
			this.node = node;
			this.sum = sum;
			this.count = count;
		}

	}

	ResultType finalResult = new ResultType(null, 0, 0);

	public TreeNode findSubtree2(TreeNode root) {
		helper(root);
		return finalResult.node;
	}

	private ResultType helper(TreeNode node) {

		if (node == null)
			return new ResultType(null, 0, 0);

		ResultType left = helper(node.left);
		ResultType right = helper(node.right);

		ResultType result = new ResultType(node, node.val + left.sum + right.sum, 1 + left.count + right.count);

		if (finalResult.node == null || finalResult.sum * result.count < result.sum * finalResult.count) {
			finalResult.node = result.node;
			finalResult.sum = result.sum;
			finalResult.count = result.count;
		}

		return result;
	}
}

package com.jasper.divideconquer;

import java.util.List;

class MultiTreeNode {
	int val;
	List<MultiTreeNode> children;

	MultiTreeNode(int x) {
		val = x;
	}
}

public class LC619_BinaryTreeLongestConsecutiveSequenceIII {

	class ResultType {
		int maxLen;
		int maxUpLen;
		int maxDownLen;

		public ResultType(int maxLen, int maxUpLen, int maxDownLen) {
			this.maxLen = maxLen;
			this.maxUpLen = maxUpLen;
			this.maxDownLen = maxDownLen;
		}
	}

	public int longestConsecutive3(MultiTreeNode root) {
		return helper(root).maxLen;
	}

	private ResultType helper(MultiTreeNode root) {
		if (root == null)
			return new ResultType(0, 0, 0);

		int up = 0;
		int down = 0;
		int len = 0;

		for (MultiTreeNode node : root.children) {
			ResultType rt = helper(node);
			if (root.val + 1 == node.val) {
				up = Math.max(up, rt.maxUpLen + 1);
			}
			if (root.val - 1 == node.val) {
				down = Math.max(down, rt.maxDownLen + 1);
			}
			len = Math.max(len, rt.maxLen);
		}
		len = Math.max(len, up + down + 1);
		return new ResultType(len, up, down);
	}

}

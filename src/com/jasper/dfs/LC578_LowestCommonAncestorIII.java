package com.jasper.dfs;

public class LC578_LowestCommonAncestorIII {

	// Solution 1 : divide and conquer
	class ResultType {
		TreeNode maxNode;
		TreeNode minNode;
		boolean isBST;

		public ResultType(boolean isBST) {
			this.isBST = isBST;
			maxNode = null;
			minNode = null;
		}
	}

	public boolean isValidBST1(TreeNode root) {
		ResultType rt = helper(root);
		return rt.isBST;
	}

	public ResultType helper(TreeNode root) {

		if (root == null)
			return new ResultType(true);

		ResultType l = helper(root.left);
		ResultType r = helper(root.right);

		if (l.isBST == false || r.isBST == false)
			return new ResultType(false);

		if (l.maxNode != null && l.maxNode.val >= root.val)
			return new ResultType(false);

		if (r.minNode != null && r.minNode.val <= root.val)
			return new ResultType(false);

		ResultType rt = new ResultType(true);
		if (l.minNode != null) {
			rt.minNode = l.minNode;
		} else {
			rt.minNode = root;
		}
		if (r.maxNode != null) {
			rt.maxNode = r.maxNode;
		} else {
			rt.maxNode = root;
		}

		return rt;
	}

	// Solution 2 : Traversal
	private int lastVal = Integer.MIN_VALUE;
	private boolean firstNode = true;

	public boolean isValidBST2(TreeNode root) {

		if (root == null) {
			return true;
		}

		if (!isValidBST2(root.left)) {
			return false;
		}

		if (!firstNode && lastVal >= root.val) {
			return false;
		}

		firstNode = false;
		lastVal = root.val;
		if (!isValidBST2(root.right)) {
			return false;
		}

		return true;
	}
}

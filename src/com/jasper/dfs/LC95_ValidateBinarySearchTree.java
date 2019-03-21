package com.jasper.dfs;

public class LC95_ValidateBinarySearchTree {

	// Solution 1
	private int lastVal = Integer.MIN_VALUE;
	private boolean firstNode = true;

	public boolean isValidBST1(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST1(root.left)) {
			return false;
		}
		if (!firstNode && lastVal >= root.val) {
			return false;
		}
		firstNode = false;
		lastVal = root.val;
		if (!isValidBST1(root.right)) {
			return false;
		}
		return true;
	}

	// Solution 2 : Divide and Conquer
	class ResultType {
		public boolean isBST;
		public TreeNode maxNode, minNode;

		public ResultType(boolean isBST) {
			this.isBST = isBST;
			this.maxNode = null;
			this.minNode = null;
		}
	}

	public boolean isValidBST2(TreeNode root) {
		return divideConquer(root).isBST;
	}

	private ResultType divideConquer(TreeNode root) {
		if (root == null) {
			return new ResultType(true);
		}

		ResultType left = divideConquer(root.left);
		ResultType right = divideConquer(root.right);

		if (!left.isBST || !right.isBST) {
			return new ResultType(false);
		}

		if (left.maxNode != null && left.maxNode.val >= root.val) {
			return new ResultType(false);
		}

		if (right.minNode != null && right.minNode.val <= root.val) {
			return new ResultType(false);
		}

		// is bst
		ResultType result = new ResultType(true);
		if (left.minNode != null) {
			result.minNode = left.minNode;
		} else {
			result.minNode = root;
		}
		if (right.maxNode != null) {
			result.maxNode = right.maxNode;
		} else {
			result.maxNode = root;
		}
		return result;
	}

}
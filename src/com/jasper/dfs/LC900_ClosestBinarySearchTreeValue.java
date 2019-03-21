package com.jasper.dfs;

public class LC900_ClosestBinarySearchTreeValue {

	public int closestValue(TreeNode root, double target) {

		if (root == null)
			return 0;

		TreeNode lowerNode = lowerBound(root, target);
		TreeNode upperNode = upperBound(root, target);

		if (lowerNode == null) {
			return upperNode.val;
		}

		if (upperNode == null) {
			return lowerNode.val;
		}

		if (target - lowerNode.val > upperNode.val - target)
			return upperNode.val;

		return lowerNode.val;
	}

	// find the node with the largest value that smaller than target
	private TreeNode lowerBound(TreeNode node, double target) {

		if (node == null)
			return null;

		// 这里即使返回的是null, 也无所谓, 因为node.val比target大, 我们是要找比target小的最大值.
		if (target < node.val) {
			return lowerBound(node.left, target);
		}

		// 因为这里是需要找到比target小于的最大值,
		// 所以当往右子树找不到的时候, 就要返回自己. 因为这个时候, 就要返回自己本身
		// root.val < target
		if (node.val < target) {
			TreeNode lowerNode = lowerBound(node.right, target);
			if (lowerNode != null) {
				return lowerNode;
			}
		}

		return node;
	}

	// find the node with the smallest value that larger than or equal to target
	private TreeNode upperBound(TreeNode node, double target) {

		if (node == null)
			return null;

		if (target > node.val) {
			return upperBound(node.right, target);
		}

		if (target < node.val) {
			TreeNode upperNode = upperBound(node.left, target);
			if (upperNode != null) {
				return upperNode;
			}
		}

		return node;
	}
}

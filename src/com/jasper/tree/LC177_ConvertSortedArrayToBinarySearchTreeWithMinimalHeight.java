package com.jasper.tree;

import com.jasper.dfs.TreeNode;

public class LC177_ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {

	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root;
		root = dfs(nums, 0, nums.length - 1);
		return root;
	}

	private TreeNode dfs(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;

		TreeNode node = new TreeNode(nums[mid]);

		node.left = dfs(nums, start, mid - 1);
		node.right = dfs(nums, mid + 1, end);

		return node;
	}

}

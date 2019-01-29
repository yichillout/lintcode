package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC11_SearchRangeInBinarySearchTree {

	public List<Integer> searchRange(TreeNode root, int k1, int k2) {
		List<Integer> result = new ArrayList<Integer>();
		helper(root, result, k1, k2);
		return result;
	}

	private void helper(TreeNode node, List<Integer> result, int k1, int k2) {
		
		if (node == null)
			return;

		if (node.val > k1) {
			helper(node.left, result, k1, k2);
		}

		if (node.val >= k1 && node.val <= k2) {
			result.add(node.val);
		}

		if (node.val < k2) {
			helper(node.right, result, k1, k2);
		}

	}
}

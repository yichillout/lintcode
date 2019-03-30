package com.jasper.dp;

import com.jasper.dfs.TreeNode;

public class LC535_HouseRobberIII {

	// Solution 1
	public int houseRobber3(TreeNode root) {
		// write your code here
		int[] rob3 = dfs(root);

		return Math.max(rob3[0], rob3[1]);
	}

	private int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[2];
		}

		int[] left = dfs(root.left);
		int[] right = dfs(root.right);

		int[] res = new int[2];

		// 这一层不偷, 下一层随便偷
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		// 这一层偷, 下一层只能不偷
		res[1] = root.val + left[0] + right[0];

		return res;
	}

}

package com.jasper.dfs;

class ResultType {
	public boolean a_exist, b_exist;
	public TreeNode node;

	ResultType(boolean a, boolean b, TreeNode n) {
		a_exist = a;
		b_exist = b;
		node = n;
	}
}

public class LC578_LowestCommonAncestorIII {

	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
		ResultType rt = helper(root, A, B);
		if (rt.a_exist && rt.b_exist)
			return rt.node;
		else
			return null;
	}

	public ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null)
			return new ResultType(false, false, null);

		ResultType left_rt = helper(root.left, A, B);
		ResultType right_rt = helper(root.right, A, B);

		boolean a_exist = left_rt.a_exist || right_rt.a_exist || root == A;
		boolean b_exist = left_rt.b_exist || right_rt.b_exist || root == B;

		if (root == A || root == B)
			return new ResultType(a_exist, b_exist, root);

		if (left_rt.node != null && right_rt.node != null)
			return new ResultType(a_exist, b_exist, root);

		if (left_rt.node != null)
			return new ResultType(a_exist, b_exist, left_rt.node);

		if (right_rt.node != null)
			return new ResultType(a_exist, b_exist, right_rt.node);

		return new ResultType(a_exist, b_exist, null);
	}
}
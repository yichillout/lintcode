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

	/*
	 * @param root: The root of the binary tree.
	 * 
	 * @param A: A TreeNode
	 * 
	 * @param B: A TreeNode
	 * 
	 * @return: Return the LCA of the two nodes.
	 */
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {

		ResultType result = helper(root, A, B);
		if (result.a_exist && result.b_exist) {
			return result.node;
		}

		return null;
	}

	private ResultType helper(TreeNode node, TreeNode A, TreeNode B) {

		if (node == null)
			return new ResultType(false, false, null);

		ResultType leftResult = helper(node.left, A, B);
		ResultType rightResult = helper(node.right, A, B);

		boolean a_exist = leftResult.a_exist || rightResult.a_exist || node == A;
		boolean b_exist = leftResult.b_exist || rightResult.b_exist || node == B;

		if (node == A || node == B)
			return new ResultType(a_exist, b_exist, node);

		if (leftResult.node != null && rightResult.node != null)
			return new ResultType(a_exist, b_exist, node);

		if (leftResult.node != null)
			return new ResultType(a_exist, b_exist, leftResult.node);

		if (rightResult.node != null)
			return new ResultType(a_exist, b_exist, rightResult.node);

		return new ResultType(a_exist, b_exist, null);

	}

}

package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC88_LowestCommonAncestorOfBinaryTree {

	// Solution 1
	// 在root为根的二叉树中找A,B的LCA:
	// 如果找到了就返回这个LCA
	// 如果只碰到A，就返回A
	// 如果只碰到B，就返回B
	// 如果都没有，就返回null
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2)
			return root;

		TreeNode left = lowestCommonAncestor1(root.left, node1, node2);
		TreeNode right = lowestCommonAncestor1(root.right, node1, node2);

		if (left != null && right != null)
			return root;

		if (left != null)
			return left;

		if (right != null)
			return right;

		return null;
	}

	// Solution 2
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode A, TreeNode B) {
		// write your code here
		List<TreeNode> pathA = findPath(root, A);
		List<TreeNode> pathB = findPath(root, B);

		int i = pathA.size() - 1;
		int j = pathB.size() - 1;
		while (i >= 0 && j >= 0 && pathA.get(i) == pathB.get(j)) {
			i--;
			j--;
		}

		return pathA.get(i + 1);
	}

	private List<TreeNode> findPath(TreeNode root, TreeNode target) {
		List<TreeNode> path = new ArrayList<>();
		if (root == null) {
			return path;
		}

		List<TreeNode> leftPath = findPath(root.left, target);
		List<TreeNode> rightPath = findPath(root.right, target);

		path.addAll(leftPath);
		path.addAll(rightPath);

		if (path.size() != 0 || root == target) {
			path.add(root);
		}

		return path;
	}
}

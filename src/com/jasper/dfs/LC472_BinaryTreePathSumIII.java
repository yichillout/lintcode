package com.jasper.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC472_BinaryTreePathSumIII {

	public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
		List<List<Integer>> results = new ArrayList<>();
		dfs(results, root, target);
		return results;
	}

	private void dfs(List<List<Integer>> results, ParentTreeNode node, int target) {
		if (node == null)
			return;

		List<Integer> path = new ArrayList<>();
		findSum(results, path, node, null, target); // no parent at the start node

		dfs(results, node.left, target);
		dfs(results, node.right, target);
	}

	private void findSum(List<List<Integer>> results, List<Integer> path, ParentTreeNode node, ParentTreeNode parent,
			int remainingTarget) {

		path.add(node.val);
		remainingTarget = remainingTarget - node.val;

		if (remainingTarget == 0) {
			results.add(new ArrayList<Integer>(path));
		}

		if (node.parent != null && node.parent != parent) {
			findSum(results, path, node.parent, node, remainingTarget);
		}

		if (node.left != null && node.left != parent) {
			findSum(results, path, node.left, node, remainingTarget);
		}

		if (node.right != null && node.right != parent) {
			findSum(results, path, node.right, node, remainingTarget);
		}

		path.remove(path.size() - 1);
	}
}

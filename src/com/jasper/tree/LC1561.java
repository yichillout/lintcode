package com.jasper.tree;

import java.util.HashSet;
import java.util.Set;

public class LC1561 {

	private TreeNode insert(TreeNode root, int node) {
		if (root == null) {
			return new TreeNode(node);
		}
		if (root.val > node) {
			root.left = insert(root.left, node);
		} else if (root.val < node) {
			root.right = insert(root.right, node);
		}
		return root;
	}

	private TreeNode buildTree(int[] numbers) {
		TreeNode root = new TreeNode(numbers[0]);
		int len = numbers.length;
		for (int i = 1; i < len; ++i) {
			insert(root, numbers[i]);
		}
		return root;
	}

	private int findDis(TreeNode root, int node) {
		int dis = 0;
		while (root.val != node) {
			dis++;
			if (root.val > node) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return dis;
	}

	private boolean check(int[] numbers, int node1, int node2) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			set.add(numbers[i]);
		}
		if (set.contains(node1) && set.contains(node2)) {
			return true;
		}
		return false;
	}

	public int bstDistance(int[] numbers, int node1, int node2) {
		if (numbers == null || numbers.length < 2) {
			return -1;
		}
		if (!check(numbers, node1, node2)) {
			return -1;
		}
		TreeNode root = buildTree(numbers);
		while (node1 > root.val && node2 > root.val || node1 < root.val && node2 < root.val) {
			if (node1 > root.val && node2 > root.val) {
				root = root.right;
			} else {
				root = root.left;
			}

		}
		return findDis(root, node1) + findDis(root, node2);
	}

}

package com.jasper.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC651_BinaryTreeVerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> results = new ArrayList<>();
		Map<Integer, List<Integer>> hash = new HashMap<>();

		Queue<Integer> qCol = new LinkedList<>();
		Queue<TreeNode> qNode = new LinkedList<>();

		if (root == null)
			return results;

		qCol.offer(0);
		qNode.offer(root);

		while (!qNode.isEmpty()) {
			int c = qCol.poll();
			TreeNode node = qNode.poll();

			if (!hash.containsKey(c)) {
				hash.put(c, new ArrayList<Integer>());
				hash.get(c).add(node.val);
			} else {
				hash.get(c).add(node.val);
			}

			if (node.left != null) {
				qCol.offer(c - 1);
				qNode.offer(node.left);
			}

			if (node.right != null) {
				qCol.offer(c + 1);
				qNode.offer(node.right);
			}
		}

		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;

		for (int num : hash.keySet()) {
			if (num < left) {
				left = num;
			}
			if (num > right) {
				right = num;
			}
		}

		for (int i = left; i <= right; i++) {
			results.add(hash.get(i));
		}

		return results;
	}
}

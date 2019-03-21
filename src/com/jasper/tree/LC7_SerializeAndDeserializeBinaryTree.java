package com.jasper.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.jasper.dfs.TreeNode;

public class LC7_SerializeAndDeserializeBinaryTree {

	// Solution 1 : BFS
	public static String serialize(TreeNode root) {

		if (root == null)
			return "{}";

		StringBuilder builder = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		builder.append("{");
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node != null) {
				builder.append(node.val);
				queue.offer(node.left);
				queue.offer(node.right);
			} else {
				builder.append("#");
			}

			if (!queue.isEmpty()) {
				builder.append(",");
			}

		}
		builder.append("}");
		return builder.toString();
	}

	public TreeNode deserialize(String data) {

		if (data == null || data.equals("{}"))
			return null;

		String[] values = data.trim().substring(1, data.length() - 1).split(",");
		List<TreeNode> nodeList = new ArrayList<>();

		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		nodeList.add(root);

		boolean isLeftChild = true;
		int index = 0;

		for (int i = 1; i < values.length; i++) {
			if (!values[i].equals("#")) {
				TreeNode p = nodeList.get(index);
				TreeNode node = new TreeNode(Integer.parseInt(values[i]));
				if (isLeftChild) {
					p.left = node;
				} else {
					p.right = node;
				}
				nodeList.add(node);
			}
			if (!isLeftChild) {
				index++;
			}
			isLeftChild = !isLeftChild;
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;

		System.out.println(serialize(node1));
	}
}

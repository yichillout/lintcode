package com.jasper.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class LC232_ConvertBinaryTreeToLinkedListsByDepth {

	public List<ListNode> binaryTreeToLists(TreeNode root) {
		List<ListNode> result = new ArrayList<ListNode>();

		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		ListNode dummy = new ListNode(0);
		ListNode lastNode = null;
		while (!queue.isEmpty()) {
			dummy.next = null;
			lastNode = dummy;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				lastNode.next = new ListNode(head.val);
				lastNode = lastNode.next;

				if (head.left != null)
					queue.offer(head.left);
				if (head.right != null)
					queue.offer(head.right);
			}
			result.add(dummy.next);
		}

		return result;
	}
}

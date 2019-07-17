package com.jasper.tree;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class LC106_ConvertSortedListToBinarySearchTree {

	private ListNode current;

	private int getListLength(ListNode head) {
		int size = 0;

		while (head != null) {
			size++;
			head = head.next;
		}

		return size;
	}

	public TreeNode sortedListToBST(ListNode head) {
		int size;

		current = head;
		size = getListLength(head);

		return sortedListToBSTHelper(size);
	}

	public TreeNode sortedListToBSTHelper(int size) {
		if (size <= 0) {
			return null;
		}

		TreeNode left = sortedListToBSTHelper(size / 2);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

		root.left = left;
		root.right = right;

		return root;
	}
}

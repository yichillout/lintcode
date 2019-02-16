package com.jasper.linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LC228_MiddleOfLinkedList {

	public ListNode middleNode(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

}

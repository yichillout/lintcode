package com.jasper.heap;

import java.util.List;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class LC104_MergeKSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {

		if (lists == null || lists.size() == 0)
			return null;

		PriorityQueue<ListNode> pq = new PriorityQueue<>((p1, p2) -> {
			return p1.val - p2.val;
		});

		for (ListNode node : lists) {
			if (node == null)
				continue;

			pq.offer(node);
		}

		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;

		while (!pq.isEmpty()) {
			ListNode tmpNode = pq.poll();
			cur.next = tmpNode;
			cur = cur.next;
			if (tmpNode.next != null) {
				pq.offer(tmpNode.next);
			}
		}

		return dummy.next;
	}

}

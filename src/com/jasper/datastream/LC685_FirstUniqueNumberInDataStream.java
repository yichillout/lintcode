package com.jasper.datastream;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}

class DataStream {

	private ListNode head;
	private ListNode tail;
	private Map<Integer, ListNode> numToPrev;
	private Set<Integer> duplicates;

	public DataStream() {
		// dummy
		head = new ListNode(0);
		tail = head;

		numToPrev = new HashMap<>();
		duplicates = new HashSet<>();
	}

	private void remove(int number) {
		ListNode prev = numToPrev.get(number);
		prev.next = prev.next.next;
		numToPrev.remove(number);

		// change tail and prev of next
		if (prev.next != null) {
			numToPrev.put(prev.next.val, prev);
		} else {
			tail = prev;
		}
	}

	public void add(int number) {
		if (duplicates.contains(number)) {
			return;
		}

		if (numToPrev.containsKey(number)) {
			remove(number);
			duplicates.add(number);
		} else {
			ListNode node = new ListNode(number);
			numToPrev.put(number, tail);
			tail.next = node;
			tail = node;
		}
	}

	public int firstUnique() {
		if (head.next != null) {
			return head.next.val;
		}
		return -1;
	}
}

public class LC685_FirstUniqueNumberInDataStream {

	public int firstUniqueNumber(int[] nums, int number) {
		DataStream ds = new DataStream();
		for (int i = 0; i < nums.length; i++) {
			ds.add(nums[i]);
			if (nums[i] == number) {
				return ds.firstUnique();
			}
		}

		return -1;
	}
}

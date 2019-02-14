package com.jasper.hashtable;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LC129_Rehashing {

	public ListNode[] rehashing(ListNode[] hashTable) {
		if (hashTable.length <= 0) {
			return hashTable;
		}
		int newcapacity = 2 * hashTable.length;
		ListNode[] newTable = new ListNode[newcapacity];
		for (int i = 0; i < hashTable.length; i++) {
			while (hashTable[i] != null) {
				int newindex = (hashTable[i].val % newcapacity + newcapacity) % newcapacity;
				if (newTable[newindex] == null) {
					newTable[newindex] = new ListNode(hashTable[i].val);
				} else {
					ListNode dummy = newTable[newindex];
					while (dummy.next != null) {
						dummy = dummy.next;
					}
					dummy.next = new ListNode(hashTable[i].val);
				}
				hashTable[i] = hashTable[i].next;
			}
		}
		return newTable;
	}

}

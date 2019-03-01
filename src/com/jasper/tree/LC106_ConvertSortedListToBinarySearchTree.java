package com.jasper.tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Item {
	int val;
	int freq;

	public Item(int val, int freq) {
		this.val = val;
		this.freq = freq;
	}
}

class ItemComparator implements Comparator<Item> {
	public int compare(Item i1, Item i2) {
		if (i1.freq == i2.freq) {
			return i1.val - i2.val;
		} else {
			return i1.freq - i2.freq;
		}
	}
}

public class LC106_ConvertSortedListToBinarySearchTree {

	public void customSort(List<Integer> arr) {

		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Item> pq = new PriorityQueue<Item>(new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				if (i1.freq == i2.freq) {
					return i1.val - i2.val;
				} else {
					return i1.freq - i2.freq;
				}
			}
		});

		for (int i = 0; i < arr.size(); i++) {
			if (!map.containsKey(arr.get(i))) {
				map.put(arr.get(i), 1);
			} else {
				map.put(arr.get(i), map.get(arr.get(i)) + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Item item = new Item(entry.getKey(), entry.getValue());
			pq.offer(item);
		}

		while (!pq.isEmpty()) {
			Item item = pq.poll();
			System.out.println("val:" + item.val + "; freq" + item.freq);
		}

	}
}

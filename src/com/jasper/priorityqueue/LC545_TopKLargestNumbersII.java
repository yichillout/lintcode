package com.jasper.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC545_TopKLargestNumbersII {

	private int maxSize;
	private Queue<Integer> minheap;

	public LC545_TopKLargestNumbersII(int k) {
		minheap = new PriorityQueue<>();
		maxSize = k;
	}

	// sorted array : O(n)
	// n heap : O(nlogn) / maxheap
	// k heap : O(klogk) / minheap: because need to pop the smallest
	public void add(int num) {
		if (minheap.size() < maxSize) {
			minheap.offer(num);
			return;
		}

		if (num > minheap.peek()) {
			minheap.poll();
			minheap.offer(num);
		}
	}

	// sorted array : O(k)
	// n heap : O(klogn)
	// k heap : O(klogk)
	public List<Integer> topk() {
		Iterator it = minheap.iterator();
		List<Integer> result = new ArrayList<Integer>();
		while (it.hasNext()) {
			result.add((Integer) it.next());
		}
		Collections.sort(result, Collections.reverseOrder());
		return result;
	}
}

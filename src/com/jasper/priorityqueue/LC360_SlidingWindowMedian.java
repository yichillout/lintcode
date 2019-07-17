package com.jasper.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC360_SlidingWindowMedian {

	public List<Integer> medianSlidingWindow(int[] nums, int k) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((x, y) -> y - x);

		for (int i = 0; i < nums.length; i++) {
			if (!minPQ.isEmpty() && nums[i] >= minPQ.peek()) {
				minPQ.add(nums[i]);
			} else {
				maxPQ.add(nums[i]);
			}

			if (i >= k) {
				if (!minPQ.isEmpty() && nums[i - k] >= minPQ.peek()) {
					minPQ.remove(nums[i - k]);
				} else {
					maxPQ.remove(nums[i - k]);
				}
			}

			if (minPQ.size() - maxPQ.size() > 1) {
				while (minPQ.size() - maxPQ.size() > 1) {
					maxPQ.add(minPQ.poll());
				}
			} else if (maxPQ.size() - minPQ.size() > 1) {
				while (maxPQ.size() - minPQ.size() > 1) {
					minPQ.add(maxPQ.poll());
				}
			}

			if (i >= k - 1) {
				if (maxPQ.size() >= minPQ.size()) {
					result.add(maxPQ.peek());
				} else {
					result.add(minPQ.peek());
				}
			}
		}

		return result;
	}
}

package com.jasper.twopoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// ***Template***
public class LC521_RemoveDuplicateNumbersInArray {

	// Solution 1 : O(n) time, O(n) space
	public int deduplication1(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; ++i) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
			}
		}

		int index = 0;
		Iterator it = set.iterator();
		while (it.hasNext()) {
			nums[index++] = (int) it.next();
		}

		return index;
	}

	// Solution 2 
	public int deduplication2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		Arrays.sort(nums);
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[index]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;
	}
}

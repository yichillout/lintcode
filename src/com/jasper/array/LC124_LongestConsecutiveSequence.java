package com.jasper.array;

import java.util.HashSet;
import java.util.Set;

public class LC124_LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {

		Set<Integer> set = new HashSet<>();

		int result = 0;

		for (int num : nums) {
			set.add(num);
		}

		for (int num : nums) {
			if (set.contains(num)) {
				set.remove(num);
				int l = num - 1;
				int r = num + 1;
				while (set.contains(l)) {
					set.remove(l);
					l--;
				}
				while (set.contains(r)) {
					set.remove(r);
					r++;
				}
				result = Math.max(result, r - l - 1);
			}
		}

		return result;
	}

}

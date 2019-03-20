package com.jasper.twopoint;

import java.util.HashMap;
import java.util.Map;

public class LC610_TwoSumDifferenceEqualsToTarget {

	public int[] twoSum7(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}

		int[] ans = new int[2];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				ans[0] = map.get(nums[i]) + 1;
				ans[1] = i + 1;
				return ans;
			}
			map.put(target + nums[i], i);
			map.put(nums[i] - target, i);
		}
		return new int[] { -1, -1 };
	}

}

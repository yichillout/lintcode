package com.jasper.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		// write your code here
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null)
			return results;

		if (nums.length == 0) {
			results.add(new ArrayList<Integer>());
			return results;
		}
		Arrays.sort(nums);

		List<Integer> subset = new ArrayList<>();
		helper(nums, 0, subset, results);

		return results;

	}

	public void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
		results.add(new ArrayList<Integer>(subset));
		for (int i = startIndex; i < nums.length; i++) {
			if (i != startIndex && nums[i] == nums[i - 1]) {
				continue;
			}
			subset.add(nums[i]);
			helper(nums, i + 1, subset, results);
			subset.remove(subset.size() - 1);
		}
	}

}

package com.jasper.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> buffer = new ArrayList<>();
		Arrays.sort(nums);
		dfs(result, buffer, nums, 0);
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> buffer, int[] nums, int startIndex) {

		result.add(new ArrayList<>(buffer));

		for (int i = startIndex; i < nums.length; i++) {
			if (i != startIndex && nums[i] == nums[i - 1]) {
				continue;
			}
			buffer.add(nums[i]);
			dfs(result, buffer, nums, i + 1);
			buffer.remove(buffer.size() - 1);
		}
	}
}

package com.jasper.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC135_CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> buffer = new ArrayList<>();
		Arrays.sort(candidates);
		int[] nums = removeDuplicates(candidates);
		dfs(result, buffer, nums, target, 0);
		return result;
	}

	private int[] removeDuplicates(int[] candidates) {

		int index = 0;
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i] != candidates[index]) {
				candidates[++index] = candidates[i];
			}
		}

		int[] nums = new int[index + 1];
		for (int i = 0; i < index + 1; i++) {
			nums[i] = candidates[i];
		}

		return nums;
	}

	private void dfs(List<List<Integer>> result, List<Integer> buffer, int[] nums, int remainingTarget,
			int startIndex) {
		if (remainingTarget == 0) {
			List<Integer> list = new ArrayList<>(buffer);
			result.add(list);
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			if (nums[i] <= remainingTarget) {
				buffer.add(nums[i]);
				dfs(result, buffer, nums, remainingTarget - nums[i], i);
				buffer.remove(buffer.size() - 1);
			}
		}
	}

}

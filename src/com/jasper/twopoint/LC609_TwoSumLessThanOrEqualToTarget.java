package com.jasper.twopoint;

import java.util.Arrays;

public class LC609_TwoSumLessThanOrEqualToTarget {

	// Solution 1
	public int twoSum2(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return 0;

		Arrays.sort(nums);

		int cnt = 0;
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else {
				cnt += right - left;
				left++;
			}
		}

		return cnt;
	}

	// Solution 2
	public int twoSum1(int[] nums, int target) {
		// Edge cases
		if (nums == null || nums.length < 2)
			return 0;

		// Two sum problem (count all duplicates)
		int count = 0;
		Arrays.sort(nums);

		// Binary search the first smaller or equal number
		// from (nums.length - 1) to i + 1
		for (int i = nums.length - 2; i >= 0; i--) {
			int end = bsFirstSmallerOrEqual(nums, i + 1, target - nums[i]);
			if (end != -1)
				count += end - i;
		}

		return count;
	}

	private int bsFirstSmallerOrEqual(int[] nums, int start, int target) {
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[end] <= target)
			return end;
		if (nums[start] <= target)
			return start;
		return -1;
	}
}

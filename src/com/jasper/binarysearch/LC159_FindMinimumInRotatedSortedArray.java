package com.jasper.binarysearch;

public class LC159_FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0, end = nums.length - 1;
		int target = nums[nums.length - 1];

		// find the first element <= target
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] <= target) {
			return nums[start];
		} else {
			return nums[end];
		}
	}

}

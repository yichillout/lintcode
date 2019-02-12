package com.jasper.twopoint;

import java.util.Arrays;

public class LC609_TwoSumLessThanOrEqualToTarget {

	public int twoSum5(int[] nums, int target) {

		if (nums == null || nums.length < 2)
			return 0;

		Arrays.sort(nums);

		int cnt = 0;
		int left = 0, right = nums.length - 1;

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

}

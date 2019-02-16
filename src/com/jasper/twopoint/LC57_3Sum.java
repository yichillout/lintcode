package com.jasper.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		if (nums == null || nums.length < 3)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[start]);
					list.add(nums[end]);
					result.add(list);

					while (start < end && nums[start] == nums[start + 1]) {
						start++;
					}

					while (start < end && nums[end] == nums[end - 1]) {
						end--;
					}

					start++;
					end--;

				} else if (sum > 0) {
					end--;
				} else {
					start++;
				}
			}
		}

		return result;
	}
}

package com.jasper.sort;

public class LC373_PartitionArrayByOddAndEven {

	public void partitionArray(int[] nums) {

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			while (start < end && nums[start] % 2 == 1) {
				start++;
			}

			while (start < end && nums[end] % 2 == 0) {
				end--;
			}

			if (start < end) {
				int tmp = nums[start];
				nums[start] = nums[end];
				nums[end] = tmp;
				start++;
				end--;
			}
		}
	}
}

package com.jasper.sort;

public class LC373_PartitionArrayByOddAndEven {

	// Solution 1 : template
	public void partitionArray1(int[] nums) {

		int start = 0;
		int end = nums.length - 1;

		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 1) {
				swap(nums, j, i);
				j++;
			}
		}

	}

	// Solution 2
	public void partitionArray2(int[] nums) {

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
				swap(nums, start, end);
				start++;
				end--;
			}
		}
	}

	private void swap(int[] nums, int x, int y) {
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}
}

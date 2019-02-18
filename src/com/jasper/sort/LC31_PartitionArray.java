package com.jasper.sort;

// template
public class LC31_PartitionArray {

	public int partitionArray(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				swap(nums, i, j);
				j++;
			}
		}

		return j;
	}

	private void swap(int[] nums, int x, int y) {
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}

}

package com.jasper.twopoint;

//***Template***
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
		// j最后的位置是第一个等于k
		return j;
	}

	private void swap(int[] nums, int x, int y) {
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}
}

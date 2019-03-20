package com.jasper.twopoint;

public class LC625_PartitionArrayII {
	
	public void partition2(int[] nums, int low, int high) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int pl = 0;
		int pr = nums.length - 1;
		int i = 0;
		while (i <= pr) {
			if (nums[i] < low) {
				swap(nums, pl, i);
				pl++;
				i++;
			} else if (nums[i] > high) {
				swap(nums, pr, i);
				pr--;
			} else {
				i++;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

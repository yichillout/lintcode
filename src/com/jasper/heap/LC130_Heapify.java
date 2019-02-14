package com.jasper.heap;

public class LC130_Heapify {

	public void heapify(int[] nums) {
		for (int i = (nums.length - 1) / 2; i >= 0; i--) {
			siftDown(nums, i);
		}
	}

	private void siftDown(int[] nums, int k) {

		while (leftChild(k) < nums.length) {
			int j = leftChild(k);

			if (j + 1 < nums.length && nums[j + 1] < nums[j])
				j++;

			// data[j] 是 leftChild 和 rightChild 中的最小值
			if (nums[k] < nums[j])
				break;

			int tmp = nums[k];
			nums[k] = nums[j];
			nums[j] = tmp;

			k = j;
		}

	}

	private int leftChild(int k) {
		return k * 2 + 1;
	}

}

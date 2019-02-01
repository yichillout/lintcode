package com.jasper.priorityqueue;

import java.util.Arrays;

public class LC544_TopKLargestNumbers {

	public int[] topk(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[] {};
		}
		quickSelect(nums, k, 0, nums.length - 1);
		int[] res = Arrays.copyOf(nums, k);
		Arrays.sort(res);
		reverse(res);
		return res;
	}

	private void reverse(int[] nums) {
		for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	private void quickSelect(int[] nums, int k, int start, int end) {
		if (start == end) {
			return;
		}
		int i = start, j = end;
		int pivot = nums[i + (j - i) / 2];
		while (i <= j) {
			while (i <= j && nums[i] > pivot) {
				i++;
			}
			while (i <= j && nums[j] < pivot) {
				j--;
			}
			if (i <= j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
		}
		if (j - start + 1 >= k) {
			quickSelect(nums, k, start, j);
		}
		if (i - start + 1 <= k) {
			quickSelect(nums, k - (i - start), i, end);
		}
	}

}

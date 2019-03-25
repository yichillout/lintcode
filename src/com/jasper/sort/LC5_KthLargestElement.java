package com.jasper.sort;

public class LC5_KthLargestElement {

	public int kthLargestElement(int k, int[] nums) {
		return helper(nums, 0, nums.length - 1, nums.length - k + 1);
	}

	private int helper(int[] nums, int s, int e, int k) {
		if (s == e)
			return nums[s];

		int p = nums[s];
		int j = s + 1;
		int i = s + 1;

		while (i <= e) {
			if (nums[i] < p) {
				swap(nums, j, i);
				j++;
			}
			i++;
		}
		j--;

		swap(nums, j, s);

		if (j - s + 1 == k) {
			return nums[j];
		} else if (j - s + 1 < k) {
			return helper(nums, j + 1, e, k - (j - s + 1));
		} else {
			return helper(nums, s, j - 1, k);
		}

	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

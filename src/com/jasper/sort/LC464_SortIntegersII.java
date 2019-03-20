package com.jasper.sort;

import java.util.Random;

// ***Template***
public class LC464_SortIntegersII {

	Random rand;

	public void sortIntegers1(int[] nums) {
		rand = new Random();
		quickSort(nums, 0, nums.length - 1);
	}

	private void quickSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}

		int index = rand.nextInt(end - start + 1) + start;
		int pivot = nums[index];
		int left = start;
		int right = end;
		int i = start;

		while (i <= right) {
			if (nums[i] < pivot) {
				swap(nums, i, left);
				left++;
				i++;
			} else if (nums[i] > pivot) {
				swap(nums, i, right);
				right--;
			} else {
				i++;
			}
		}

		// nums[start... right]
		quickSort(nums, start, left - 1);
		// nums[left ... end]
		quickSort(nums, right + 1, end);
	}

	private void swap(int[] nums, int index1, int index2) {
		int tmp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = tmp;
	}

	// Solution 2 : merge sort
	public void sortIntegers2(int[] nums) {
		// use a shared temp array, the extra memory is O(n) at least
		int[] temp = new int[nums.length];
		mergeSort(nums, 0, nums.length - 1, temp);
	}

	private void mergeSort(int[] nums, int start, int end, int[] temp) {
		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;

		mergeSort(nums, start, mid, temp);
		mergeSort(nums, mid + 1, end, temp);
		merge(nums, start, mid, end, temp);
	}

	private void merge(int[] nums, int start, int mid, int end, int[] temp) {
		int left = start;
		int right = mid + 1;
		int index = start;

		// merge two sorted subarrays in nums to temp array
		while (left <= mid && right <= end) {
			if (nums[left] <= nums[right]) {
				temp[index++] = nums[left++];
			} else {
				temp[index++] = nums[right++];
			}
		}
		while (left <= mid) {
			temp[index++] = nums[left++];
		}
		while (right <= end) {
			temp[index++] = nums[right++];
		}

		// copy temp back to nums
		for (index = start; index <= end; index++) {
			nums[index] = temp[index];
		}
	}

}

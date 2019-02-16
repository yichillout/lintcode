package com.jasper.sort;

// ***Template***
public class LC148_SortColors {

	public void sortColors(int[] nums) {

		// num[0...zero] == 0
		// num[zero+1...i-1] == 1
		// num[two...n-1] == 2

		int zero = -1; // [0...zero] == 0
		int two = nums.length; // [two...n-1] == 2
		int i = 0;
		while (i < two) {
			if (nums[i] == 1) {
				i++;
			} else if (nums[i] == 2) {
				two--;
				swap(nums, i, two);
			} else { // nums[i] == 0
				zero++;
				swap(nums, zero, i);
				i++;
			}
		}

	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}

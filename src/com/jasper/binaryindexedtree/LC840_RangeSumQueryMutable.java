package com.jasper.binaryindexedtree;

class NumArray {

	private int[] arr;
	private int[] bit;

	public NumArray(int[] nums) {
		arr = new int[nums.length];
		bit = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			update(i, nums[i]);
		}
	}

	public void update(int index, int val) {
		int delta = val - arr[index];
		arr[index] = val;

		for (int i = index + 1; i < bit.length; i = i + lowbit(i)) {
			bit[i] += delta;
		}
	}

	public int sumRange(int left, int right) {
		return getPrefixSum(right) - getPrefixSum(left - 1);
	}

	public int getPrefixSum(int index) {
		int sum = 0;
		for (int i = index + 1; i > 0; i = i - lowbit(i)) {
			sum += bit[i];
		}
		return sum;
	}

	private int lowbit(int x) {
		return x & (-x);
	}
}

public class LC840_RangeSumQueryMutable {

}

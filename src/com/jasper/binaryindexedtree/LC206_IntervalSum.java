package com.jasper.binaryindexedtree;

import java.util.ArrayList;
import java.util.List;

import com.jasper.interval.Interval;

class BITArray {

	long[] arr;
	long[] bit;

	public BITArray(int[] arr) {
		this.arr = new long[arr.length];
		this.bit = new long[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			update(i, (long) arr[i]);
		}
	}

	public void update(int index, long val) {
		long diff = val - arr[index];
		arr[index] = val;

		for (int i = index + 1; i < bit.length; i = i + lowbit(i)) {
			bit[i] += diff;
		}
	}

	public long sumRange(int index1, int index2) {
		return getPrefixSum(index2) - getPrefixSum(index1 - 1);
	}

	public long getPrefixSum(int index) {
		long sum = 0;
		for (int i = index + 1; i > 0; i = i - lowbit(i)) {
			sum += bit[i];
		}
		return sum;
	}

	private int lowbit(int n) {
		return n & (-n);
	}

}

public class LC206_IntervalSum {

	public List<Long> intervalSum(int[] A, List<Interval> queries) {

		List<Long> result = new ArrayList<>();

		BITArray numsArray = new BITArray(A);

		for (Interval interval : queries) {
			result.add(numsArray.sumRange(interval.start, interval.end));
		}

		return result;
	}
}

package com.jasper.binarysearch;

public class LC617_MaximumAverageSubarrayII {

	public double maxAverage(int[] nums, int k) {

		double start = Double.MAX_VALUE;
		double end = Double.MIN_VALUE;
		for (int num : nums) {
			start = Math.min(start, num);
			end = Math.max(end, num);
		}

		while (start + 1e-6 < end) {
			double mid = start + (end - start) / 2;
			if (canFind(nums, k, mid)) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (canFind(nums, k, end)) {
			return end;
		}

		return start;
	}

	private boolean canFind(int[] nums, int k, double avg) {
		double sum = 0;
		double preSum = 0;
		double minPreSum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] - avg;

			if (i >= k - 1 && sum >= 0) {
				return true;
			}

			if (i >= k) {
				preSum += nums[i - k] - avg;
				minPreSum = Math.min(minPreSum, preSum);
				if (sum - minPreSum >= 0) {
					return true;
				}
			}
		}
		return false;
	}

}

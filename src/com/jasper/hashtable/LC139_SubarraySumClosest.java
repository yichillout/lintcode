package com.jasper.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC139_SubarraySumClosest {

	public static int[] subarraySumClosest(int[] nums) {

		int[] results = new int[2];

		if (nums == null || nums.length == 0) {
			return new int[] {};
		}

		if (nums.length == 1) {
			return new int[] { 0, 0 };
		}

		Map<Integer, Integer> map = new HashMap<>();
		int[] prefixSum = new int[nums.length + 1];
		int sum = 0;
		map.put(0, -1);
		prefixSum[0] = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				results[0] = map.get(sum) + 1;
				results[1] = i;
				return results;
			}
			map.put(sum, i);
			prefixSum[i + 1] = sum;
		}

		Arrays.sort(prefixSum);

		int minDiff = Integer.MAX_VALUE;
		int left = 0, right = 0;

		for (int i = 0; i < prefixSum.length - 1; i++) {
			if (minDiff > Math.abs(prefixSum[i] - prefixSum[i + 1])) {
				minDiff = Math.abs(prefixSum[i] - prefixSum[i + 1]);
				left = prefixSum[i];
				right = prefixSum[i + 1];
			}
		}
		if (map.get(left) < map.get(right)) {
			results[0] = map.get(left) + 1;
			results[1] = map.get(right);
		} else {
			results[0] = map.get(right) + 1;
			results[1] = map.get(left);
		}
		return results;
	}

	public static void main(String[] args) {
		int[] nums = { -3, 1, 1, -3, 5 };
		int[] result = subarraySumClosest(nums);
	}
}

package com.jasper.interval;

import java.util.ArrayList;
import java.util.List;

public class LC641_MissingRanges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			addRange(result, lower, upper);
			return result;
		}

		addRange(result, lower, (long) nums[0] - 1);

		for (int i = 1; i < nums.length; i++) {
			addRange(result, (long) nums[i - 1] + 1, (long) nums[i] - 1);
		}

		addRange(result, (long) nums[nums.length - 1] + 1, upper);

		return result;
	}

	private void addRange(List<String> result, long x, long y) {
		if (x > y) {
			return;
		}

		if (x == y) {
			result.add(x + "");
			return;
		}

		result.add(x + "->" + y);
	}

}

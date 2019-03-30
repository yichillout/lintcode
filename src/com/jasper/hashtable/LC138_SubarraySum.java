package com.jasper.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC138_SubarraySum {

	public List<Integer> subarraySum(int[] nums) {
		List<Integer> result = new ArrayList<>();

		Map<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sumMap.containsKey(sum)) {
				result.add(sumMap.get(sum) + 1);
				result.add(i);
				break;
			}
			sumMap.put(sum, i);
		}
		System.out.println(sumMap);
		return result;
	}

}

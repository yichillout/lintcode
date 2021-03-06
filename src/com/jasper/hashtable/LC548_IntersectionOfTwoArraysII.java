package com.jasper.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC548_IntersectionOfTwoArraysII {

	// hashmap       
	// sorted
	// binary search
	
	public int[] intersection(int[] nums1, int[] nums2) {
		// Write your code here
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; ++i) {
			if (map.containsKey(nums1[i]))
				map.put(nums1[i], map.get(nums1[i]) + 1);
			else
				map.put(nums1[i], 1);
		}

		List<Integer> results = new ArrayList<Integer>();

		for (int i = 0; i < nums2.length; ++i)
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				results.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}

		int result[] = new int[results.size()];
		for (int i = 0; i < results.size(); ++i)
			result[i] = results.get(i);

		return result;
	}

}

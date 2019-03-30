package com.jasper.binarysearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC547_IntersectionOfTwoArrays {

	// version 1: sort & merge T:O(nlogn + mlogm) M:O(1)
	// version 2: hash map T:O(n + m) M:O(min(m,n))
	// version 3: sort & binary search T:O((n+m)log(n)) M:(1)

	// version 1: sort & merge
	public int[] intersection1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		Set<Integer> l = new HashSet<>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				l.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] res = new int[l.size()];
		int index = 0;
		for (Integer k : l) {
			res[index] = k;
			index++;
		}
		return res;
	}

	// version 2: hash map
	public int[] intersection2(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}

		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			hash.add(nums1[i]);
		}

		HashSet<Integer> resultHash = new HashSet<>();
		for (int i = 0; i < nums2.length; i++) {
			if (hash.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
				resultHash.add(nums2[i]);
			}
		}

		int size = resultHash.size();
		int[] result = new int[size];
		int index = 0;
		for (Integer num : resultHash) {
			result[index++] = num;
		}

		return result;
	}

	// version 3: sort & binary search
	public int[] intersection3(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}

		HashSet<Integer> set = new HashSet<>();

		Arrays.sort(nums1);
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				continue;
			}
			if (binarySearch(nums1, nums2[i])) {
				set.add(nums2[i]);
			}
		}

		int[] result = new int[set.size()];
		int index = 0;
		for (Integer num : set) {
			result[index++] = num;
		}

		return result;
	}

	private boolean binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (nums[start] == target) {
			return true;
		}
		if (nums[end] == target) {
			return true;
		}

		return false;
	}
}
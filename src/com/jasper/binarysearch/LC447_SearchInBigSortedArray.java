package com.jasper.binarysearch;

class ArrayReader {
	public int get(int index) {
		// return the number on given index,
		// return 2147483647 if the index is invalid.
		return 1;
	}
};

public class LC447_SearchInBigSortedArray {

	// Find the first index of a target number. Your algorithm should be in
	// O(logk), where k is the first index of the target number.
	public int searchBigSortedArray(ArrayReader reader, int target) {

		int index = 1;
		while (reader.get(index) < target) {
			index = index * 2;
		}

		int start = 0;
		int end = index;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (reader.get(mid) == target) {
				end = mid;
			} else if (reader.get(mid) < target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (reader.get(start) == target)
			return start;

		if (reader.get(end) == target)
			return end;

		return -1;
	}

}

package com.jasper.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Element {

	public int row, col, val;

	Element(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}

public class LC104_MergeKSortedLists {

	// Example
	// Given 3 sorted arrays:
	//
	// [
	// [1, 3, 5, 7],
	// [2, 4, 6],
	// [0, 8, 9, 10, 11]
	// ]
	//
	// return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

	private Comparator<Element> ElementComparator = new Comparator<Element>() {
		public int compare(Element left, Element right) {
			return left.val - right.val;
		}
	};

	public int[] mergekSortedArrays(int[][] arrays) {
		if (arrays == null) {
			return new int[0];
		}

		int total_size = 0;
		Queue<Element> Q = new PriorityQueue<Element>(arrays.length, ElementComparator);

		for (int i = 0; i < arrays.length; i++) {
			if (arrays[i].length > 0) {
				Element elem = new Element(i, 0, arrays[i][0]);
				Q.add(elem);
				total_size += arrays[i].length;
			}
		}

		int[] result = new int[total_size];
		int index = 0;
		while (!Q.isEmpty()) {
			Element elem = Q.poll();
			result[index++] = elem.val;
			if (elem.col + 1 < arrays[elem.row].length) {
				elem.col += 1;
				elem.val = arrays[elem.row][elem.col];
				Q.add(elem);
			}
		}

		return result;
	}

}

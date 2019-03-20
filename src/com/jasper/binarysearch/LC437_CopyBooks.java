package com.jasper.binarysearch;

public class LC437_CopyBooks {

	public int copyBooks(int[] pages, int k) {

		int start = 0;
		int end = 0;

		for (int page : pages) {
			end += page;
			start = Math.max(start, page);
		}

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (getNum(pages, mid) <= k) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (getNum(pages, start) <= k) {
			return start;
		}

		if (getNum(pages, end) <= k) {
			return end;
		}

		return 0;
	}

	private int getNum(int[] pages, int time) {
		int sum = 1;
		int cur = 0;
		for (int page : pages) {
			if (cur + page > time) {
				sum++;
				cur = 0;
			}
			cur += page;
		}
		return sum;
	}

}

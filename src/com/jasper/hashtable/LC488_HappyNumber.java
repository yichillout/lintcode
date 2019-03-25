package com.jasper.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LC488_HappyNumber {

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int cur = n;
		while (!set.contains(cur)) {
			set.add(cur);
			cur = getNum(cur);
			if (cur == 1) {
				return true;
			}
		}
		return false;
	}

	private int getNum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}

}

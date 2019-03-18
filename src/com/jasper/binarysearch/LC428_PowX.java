package com.jasper.binarysearch;

public class LC428_PowX {

	public double myPow(double x, int n) {

		boolean isNegative = false;
		if (n < 0) {
			x = 1 / x;
			isNegative = true;
			n = -(n + 1); // handle integer overflow
		}
		double ans = 1, temp = x;
		while (n != 0) {
			if (n % 2 == 1) {
				ans *= temp;
			}
			temp *= temp;
			n /= 2;
		}

		if (isNegative) {
			ans *= x;
		}

		return ans;
	}
}

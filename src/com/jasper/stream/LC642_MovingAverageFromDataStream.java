package com.jasper.stream;

public class LC642_MovingAverageFromDataStream {

	public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(3);
		System.out.println(ma.next(1));
		System.out.println(ma.next(10));
		System.out.println(ma.next(3));
		System.out.println(ma.next(5));
	}
}

class MovingAverage {

	int id;
	int size;
	double[] sum;

	MovingAverage(int s) {
		id = 0;
		size = s;
		sum = new double[size + 1]; // 滚动
	}

	int mod(int x) {
		return x % (size + 1);
	}

	public double next(int val) {
		id++;
		sum[mod(id)] = sum[mod(id - 1)] + val;
		if (id - size >= 0) {
			return (sum[mod(id)] - sum[mod(id - size)]) / size;
		} else {
			return sum[mod(id)] / id;
		}
	}
}
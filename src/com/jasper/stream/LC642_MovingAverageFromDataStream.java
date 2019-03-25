package com.jasper.stream;

import java.util.LinkedList;
import java.util.Queue;

public class LC642_MovingAverageFromDataStream {

	public static void main(String[] args) {
		MovingAverage1 ma = new MovingAverage1(3);
		System.out.println(ma.next(1));
		System.out.println(ma.next(10));
		System.out.println(ma.next(3));
		System.out.println(ma.next(5));
	}
}

// Solution 1 : queue
class MovingAverage1 {

	Queue<Integer> queue;
	int size;
	double sum;

	public MovingAverage1(int size) {
		this.queue = new LinkedList<>();
		this.size = size;
		this.sum = 0;
	}

	public double next(int val) {
		sum += val;
		queue.offer(val);
		if (queue.size() > size) {
			sum -= queue.poll();
		}
		return sum / queue.size();
	}
}
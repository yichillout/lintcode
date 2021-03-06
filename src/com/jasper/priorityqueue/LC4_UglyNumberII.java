package com.jasper.priorityqueue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC4_UglyNumberII {

	// Ugly number is a number that only have factors 2, 3 and 5.
	// Design an algorithm to find the nth ugly number.
	// The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

	public int nthUglyNumber(int n) {

		Queue<Long> Q = new PriorityQueue<Long>();
		HashSet<Long> inQ = new HashSet<Long>();
		Long[] primes = new Long[3];
		primes[0] = Long.valueOf(2);
		primes[1] = Long.valueOf(3);
		primes[2] = Long.valueOf(5);
		for (int i = 0; i < 3; i++) {
			Q.add(primes[i]);
			inQ.add(primes[i]);
		}
		Long number = Long.valueOf(1);
		for (int i = 1; i < n; i++) {
			number = Q.poll();
			for (int j = 0; j < 3; j++) {
				if (!inQ.contains(primes[j] * number)) {
					Q.add(number * primes[j]);
					inQ.add(number * primes[j]);
				}
			}
		}
		return number.intValue();
	}

}

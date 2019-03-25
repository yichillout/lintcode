package com.jasper.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LC494_ImplementStackByTwoQueues {

	// Solution 1 : two queue
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	public void push(int x) {
		if (q1.isEmpty()) {
			q1.offer(x);
			while (!q2.isEmpty()) {
				q1.offer(q2.poll());
			}
		} else {
			q2.offer(x);
			while (!q1.isEmpty()) {
				q2.offer(q1.poll());
			}
		}
	}

	public void pop() {
		if (!q1.isEmpty()) {
			q1.poll();
		} else {
			q2.poll();
		}
	}

	public int top() {
		if (!q1.isEmpty()) {
			return q1.peek();
		} else {
			return q2.peek();
		}
	}

	public boolean isEmpty() {
		return q1.isEmpty() && q2.isEmpty();
	}

}

package com.jasper.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC612_KClosestPoints {

	// solution 1
	private Point origin;
	private int size;

	public Point[] kClosest1(Point[] points, Point origin, int k) {
		if (points == null || points.length == 0) {
			return points;
		}

		this.origin = origin;
		heapify(points); // O(n)

		Point[] results = new Point[k];
		// O(klogn)
		for (int i = 0; i < k; i++) {
			results[i] = pop(points);
		}

		return results;
	}

	private void heapify(Point[] points) {
		size = points.length;
		for (int i = size / 2; i >= 0; i--) {
			siftDown(points, i);
		}
	}

	private void siftDown(Point[] points, int index) {
		while (index < size) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;
			int min = index;
			if (left < size && compare(points[min], points[left]) > 0) {
				min = left;
			}
			if (right < size && compare(points[min], points[right]) > 0) {
				min = right;
			}
			if (index != min) {
				Point temp = points[index];
				points[index] = points[min];
				points[min] = temp;
				index = min;
			} else {
				break;
			}
		}
	}

	private Point pop(Point[] points) {
		Point top = points[0];
		points[0] = points[size - 1];
		this.size--;

		siftDown(points, 0);
		return top;
	}

	private int compare(Point a, Point b) {
		int square = getDistanceSquare(a, origin) - getDistanceSquare(b, origin);
		if (square != 0) {
			return square;
		}
		if (a.x != b.x) {
			return a.x - b.x;
		}
		return a.y - b.y;
	}

	private int getDistanceSquare(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

	// solution 2
	public static Point[] kClosest2(Point[] points, Point origin, int k) {

		PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> {
			int diff = getDistance(p2, origin) - getDistance(p1, origin);
			if (diff != 0)
				return diff;

			if (p2.x - p1.x != 0)
				return p2.x - p1.x;

			return p2.y - p1.y;
		});

		for (Point point : points) {
			pq.offer(point);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		Point[] results = new Point[pq.size()];

		int index = results.length - 1;
		while (!pq.isEmpty()) {
			results[index--] = pq.poll();
		}

		return results;
	}

	private static int getDistance(Point p1, Point p2) {
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
	}

	public static void main(String[] args) {
		Point origin = new Point(0, 0);
		Point point1 = new Point(4, 6);
		Point point2 = new Point(4, 7);
		Point point3 = new Point(4, 4);
		Point point4 = new Point(2, 5);
		Point point5 = new Point(1, 1);
		Point[] points = { point1, point2, point3, point4, point5 };
		kClosest2(points, origin, 3);
	}

}

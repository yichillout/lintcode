package priorityqueue;

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
	private Point global_origin = null;

	public Point[] kClosest2(Point[] points, Point origin, int k) {

		global_origin = origin;
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				int diff = getDistanceSquare(b, global_origin) - getDistanceSquare(a, global_origin);
				if (diff == 0)
					diff = b.x - a.x;
				if (diff == 0)
					diff = b.y - a.y;
				return diff;
			}
		});

		for (int i = 0; i < points.length; i++) {
			pq.offer(points[i]);
			if (pq.size() > k)
				pq.poll();
		}

		k = pq.size();
		Point[] ret = new Point[k];
		while (!pq.isEmpty())
			ret[--k] = pq.poll();
		return ret;
	}

}

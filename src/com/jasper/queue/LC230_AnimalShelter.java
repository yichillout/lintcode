package com.jasper.queue;

import java.util.LinkedList;

// Solution 1 : two LinkedList
class AnimalShelter1 {

	public class Node {
		public String name;
		public int time;

		public Node(String name, int time) {
			this.name = name;
			this.time = time;
		}
	}

	private int total = 0;
	private LinkedList<Node> dogs = new LinkedList<>();
	private LinkedList<Node> cats = new LinkedList<>();

	public void enqueue(String name, int type) {
		if (type == 0) {
			cats.add(new Node(name, total));
		} else {
			dogs.add(new Node(name, total));
		}
		total++;
	}

	public String dequeueAny() {
		if (cats.size() == 0) {
			return dequeueDog();
		}

		if (dogs.size() == 0) {
			return dequeueCat();
		}

		if (cats.get(0).time <= dogs.get(0).time) {
			return dequeueCat();
		} else {
			return dequeueDog();
		}
	}

	public String dequeueDog() {
		if (dogs.size() > 0) {
			String name = dogs.get(0).name;
			dogs.removeFirst();
			return name;
		} else {
			return null;
		}
	}

	public String dequeueCat() {
		if (cats.size() > 0) {
			String name = cats.get(0).name;
			cats.removeFirst();
			return name;
		} else {
			return null;
		}
	}
}

public class LC230_AnimalShelter {

}

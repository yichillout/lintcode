package com.jasper.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Solution 1
class LoadBalancer1 {

	private Map<Integer, Integer> dict = null;
	private List<Integer> servers = null;

	public LoadBalancer1() {
		dict = new HashMap<Integer, Integer>();
		servers = new ArrayList<Integer>();
	}

	// @param server_id add a new server to the cluster
	// @return void
	public void add(int server_id) {
		// Write your code here
		int m = servers.size();
		dict.put(server_id, m);
		servers.add(server_id);
	}

	// @param server_id server_id remove a bad server from the cluster
	// @return void
	public void remove(int server_id) {
		// Write your code here
		int index = dict.get(server_id);
		int m = servers.size();
		dict.put(servers.get(m - 1), index);
		servers.set(index, servers.get(m - 1));
		servers.remove(m - 1);
		dict.remove(server_id);
	}

	// @return pick a server in the cluster randomly with equal probability
	public int pick() {
		// Write your code here
		Random r = new Random();
		int m = servers.size();
		int index = Math.abs(r.nextInt()) % m;
		return servers.get(index);
	}

}

// Solution 2 : 高频班
class LoadBalancer2 {

	int size;
	List<Integer> servers;
	Map<Integer, Integer> pos;
	Random random;

	public LoadBalancer2() {
		size = 0;
		servers = new ArrayList<Integer>();
		pos = new HashMap<Integer, Integer>();
		random = new Random();
	}

	/*
	 * @param server_id: add a new server to the cluster
	 * 
	 * @return: nothing
	 */
	public void add(int server_id) {
		if (!pos.containsKey(server_id)) {
			pos.put(server_id, size);
			servers.add(server_id);
			size++;
		}
	}

	/*
	 * @param server_id: server_id remove a bad server from the cluster
	 * 
	 * @return: nothing
	 */
	public void remove(int server_id) {
		if (pos.containsKey(server_id)) {
			int lastServer = servers.get(size - 1);
			int removeIndex = pos.get(server_id);

			pos.put(lastServer, removeIndex);
			servers.set(removeIndex, lastServer);

			pos.remove(server_id);
			servers.remove(size - 1);
			size--;
		}
	}

	/*
	 * @return: pick a server in the cluster randomly with equal probability
	 */
	public int pick() {
		return servers.get(random.nextInt(size));
	}
}

public class LC526_LoadBalancer {

}

package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC152_Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> buffer = new ArrayList<>();
		dfs(result, buffer, n, k, 1);
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> buffer, int n, int k, int start) {

		if (buffer.size() == k) {
			List<Integer> list = new ArrayList<>(buffer);
			result.add(list);
			return;
		}

		for (int i = start; i <= n; i++) {
			buffer.add(i);
			dfs(result, buffer, n, k, i + 1);
			buffer.remove(buffer.size() - 1);
		}
	}
}

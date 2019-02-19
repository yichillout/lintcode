package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC652_Factorization {

	/*
	 * Given n = 8 
	 * return [[2,2,2],[2,4]] 
	 * 8 = 2 x 2 x 2 = 2 x 4
	 * 
	 * Given n = 1 
	 * return []
	 * 
	 * Given n = 12 
	 * return [[2,6],[2,2,3],[3,4]]
	 */

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> buffer = new ArrayList<>();
		dfs(result, buffer, n, 2);
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> buffer, int n, int start) {

		if (n <= 1) {
			if (buffer.size() > 1) {
				List<Integer> list = new ArrayList<>(buffer);
				result.add(list);
				return;
			}
		}

		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				buffer.add(i);
				dfs(result, buffer, n / i, i);
				buffer.remove(buffer.size() - 1);
			}
		}

	}
}

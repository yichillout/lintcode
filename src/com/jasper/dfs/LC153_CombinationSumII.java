package com.jasper.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC153_CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return results;
		}

		Arrays.sort(candidates);
		List<Integer> combination = new ArrayList<Integer>();
		helper(candidates, 0, combination, target, results);

		return results;
	}

	private void helper(int[] candidates, int startIndex, List<Integer> combination, int remainTarget,
			List<List<Integer>> results) {
		if (remainTarget == 0) {
			results.add(new ArrayList<Integer>(combination));
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {
			if (i != startIndex && candidates[i] == candidates[i - 1]) {
				continue;
			}
			if (remainTarget < candidates[i]) {
				break;
			}
			combination.add(candidates[i]);
			helper(candidates, i + 1, combination, remainTarget - candidates[i], results);
			combination.remove(combination.size() - 1);
		}
	}

}

package com.jasper.dfs;

import java.util.HashMap;
import java.util.Map;

public class LC863_BinaryTreePathSumIV {

	int ans = 0;
	Map<Integer, Integer> map;

	public int pathSum(int[] nums) {

		map = new HashMap<>();
		for (int i : nums) {
			int key = i / 10;
			int val = i % 10;

			map.put(key, val);
		}

		dfs(nums[0] / 10, 0);

		return ans;
	}

	private void dfs(int root, int sum) {
		if (!map.containsKey(root))
			return;

		sum += map.get(root);

		int depth = root / 10;
		int pos = root % 10;

		int left = (depth + 1) * 10 + (pos * 2 - 1);
		int right = left + 1;

		if (!map.containsKey(left) && !map.containsKey(right)) {
			ans += sum;
			return;
		}

		dfs(left, sum);
		dfs(right, sum);
	}
}

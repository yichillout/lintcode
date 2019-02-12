package com.jasper.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC58_4Sum {

	// Solution 1
	public List<List<Integer>> fourSum1(int[] num, int target) {

		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < num.length - 2; j++) {
				if (j != i + 1 && num[j] == num[j - 1])
					continue;

				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(num[left]);
						tmp.add(num[right]);
						rst.add(tmp);
						left++;
						right--;
						while (left < right && num[left] == num[left - 1]) {
							left++;
						}
						while (left < right && num[right] == num[right + 1]) {
							right--;
						}
					}
				}
			}
		}

		return rst;
	}

	// Solution 2 : HashMap
	public List<List<Integer>> fourSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 4) {
			return new ArrayList<>();
		}
		Arrays.sort(numbers);
		List<List<Integer>> results = new ArrayList<>();
		Map<Integer, List<List<Integer>>> map = createTwoSumMap(numbers);

		for (int i = 0; i <= numbers.length - 2; ++i) {
			if (i != 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			for (int j = i + 1; j <= numbers.length - 1; ++j) {
				if (j != i + 1 && numbers[j] == numbers[j - 1]) {
					continue;
				}
				int remainTwoSum = target - (numbers[i] + numbers[j]);
				if (!map.containsKey(remainTwoSum)) {
					continue;
				}
				List<List<Integer>> pairs = map.get(remainTwoSum);
				int previousNum1 = Integer.MAX_VALUE;
				int previousNum2 = Integer.MAX_VALUE;
				for (List<Integer> pair : pairs) {
					int thirdIndex = pair.get(0), fourthIndex = pair.get(1);
					if (thirdIndex > j && fourthIndex > j && numbers[thirdIndex] != previousNum1
							&& numbers[fourthIndex] != previousNum2) {
						List<Integer> result = new ArrayList<>();
						result.add(numbers[i]);
						result.add(numbers[j]);
						result.add(numbers[thirdIndex]);
						result.add(numbers[fourthIndex]);
						results.add(result);
						previousNum1 = numbers[thirdIndex];
						previousNum2 = numbers[fourthIndex];
					}
				}
			}
		}
		return results;
	}

	// key: sum, value: list of index pairs
	private Map<Integer, List<List<Integer>>> createTwoSumMap(int[] numbers) {
		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		for (int i = 0; i <= numbers.length - 2; ++i) {
			for (int j = i + 1; j <= numbers.length - 1; ++j) {
				int twoSum = numbers[i] + numbers[j];
				List<Integer> pair = new ArrayList<>();
				pair.add(i);
				pair.add(j);
				if (map.containsKey(twoSum)) {
					map.get(twoSum).add(pair);
				} else {
					List<List<Integer>> pairs = new ArrayList<>();
					pairs.add(pair);
					map.put(twoSum, pairs);
				}
			}
		}
		return map;
	}
}

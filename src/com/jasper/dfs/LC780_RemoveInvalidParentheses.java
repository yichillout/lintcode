package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC780_RemoveInvalidParentheses {

	/*
	 * 1.从左到右遍历String获得左括号和右括号的计数
	 * 2.从左到右遍历String，如果碰到左括号或右括号，就删除左括号或右括号，更新计数，然后把剩下的String放入DFS递归，
	 * 注意当有连续的左括号或者右括号的时候，必须先删前面的 
	 * 3.DFS退出的条件是左括号和有括号的计数均为0
	 */
	
	public List<String> removeInvalidParentheses(String s) {

		List<String> results = new ArrayList<String>();
		int[] result = getLeftRightCount(s);
		dfs(s, 0, result[0], result[1], results);

		return results;
	}

	private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> results) {
		if (leftCount == 0 && rightCount == 0 && isStringValid(s)) {
			results.add(s);
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			if (i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
				continue;
			}

			if (leftCount > 0 && s.charAt(i) == '(') {
				dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, results);
			}

			if (rightCount > 0 && s.charAt(i) == ')') {
				dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, results);
			}
		}
	}

	private boolean isStringValid(String s) {
		int[] result = getLeftRightCount(s);
		return result[0] == 0 && result[1] == 0;
	}

	private int[] getLeftRightCount(String s) {
		int[] count = new int[] { 0, 0 };
		for (char c : s.toCharArray()) {
			if (c == '(') {
				count[0]++;
			}
			if (c == ')') {
				if (count[0] > 0) {
					count[0]--;
				} else {
					count[1]++;
				}
			}
		}
		return count;
	}
}

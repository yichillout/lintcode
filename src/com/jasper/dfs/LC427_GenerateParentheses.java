package com.jasper.dfs;

import java.util.ArrayList;

public class LC427_GenerateParentheses {

	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}
		helper(result, "", n, n);
		return result;
	}

	public void helper(ArrayList<String> result, String paren, int left, int right) {
		if (left == 0 && right == 0) {
			result.add(paren);
			return;
		}

		if (left > 0) {
			helper(result, paren + "(", left - 1, right);
		}

		if (right > 0 && left < right) {
			helper(result, paren + ")", left, right - 1);
		}
	}
}

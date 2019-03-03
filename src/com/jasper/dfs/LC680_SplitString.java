package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

//***Template***
public class LC680_SplitString {

	public List<List<String>> splitString(String s) {

		List<List<String>> res = new ArrayList<>();
		List<String> buffer = new ArrayList<>();
		dfs(res, buffer, s);
		return res;
	}

	private void dfs(List<List<String>> res, List<String> buffer, String s) {

		if (s.equals("")) {
			List<String> list = new ArrayList<>(buffer);
			res.add(list);
			return;
		}

		for (int i = 1; i <= 2; i++) {
			if (i <= s.length()) {
				buffer.add(s.substring(0, i));
				dfs(res, buffer, s.substring(i));
				buffer.remove(buffer.size() - 1);
			}
		}
	}
}

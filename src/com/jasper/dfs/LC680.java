package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

//***Template***
public class LC680 {

	public List<List<String>> splitString(String s) {
		// write your code here
		List<List<String>> res = new ArrayList<>();
		List<String> local = new ArrayList<>();

		dfs(s, local, res);

		return res;
	}

	// s is the string
	// index is the split position
	private void dfs(String s, int index, List<String> local, List<List<String>> res) {
		// 这里 >= 是为了处理空字符串这种特殊情况, 不然res里面什么都没有, 其实
		// 应该return一个含有空集的集合
		if (index >= s.length()) {
			res.add(new ArrayList<String>(local));
			return;
		}

		// 切一个字符
		if (index + 1 <= s.length()) {
			local.add(s.substring(index, index + 1));
			dfs(s, index + 1, local, res);
			local.remove(local.size() - 1);
		}

		// 切两个字符
		if (index + 2 <= s.length()) {
			local.add(s.substring(index, index + 2));
			dfs(s, index + 2, local, res);
			local.remove(local.size() - 1);
		}

		return;
	}

	// 这里提供一个更通用的dfs循环做法, 如果不喜欢第一种的话(因为没啥通用性, 适用的题目范围比较少)可以参考这种
	// s is the string, 每次都先选一个字符, 然后再选第二个个字符, 最后把剩下的字符串传下去递归
	private void dfs(String s, List<String> local, List<List<String>> res) {

		if (s.equals("")) {
			res.add(new ArrayList<String>(local));
			return;
		}

		for (int i = 1; i <= 2; i++) {
			if (i <= s.length()) {
				local.add(s.substring(0, i));
				dfs(s.substring(i, s.length()), local, res);
				local.remove(local.size() - 1);
			}
		}
	}
}

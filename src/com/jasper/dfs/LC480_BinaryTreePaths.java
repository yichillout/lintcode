package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC480_BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();

		if (root == null)
			return paths;

		if (root.left == null && root.right == null) {
			paths.add("" + root.val);
			return paths;
		}

		List<String> leftpaths = binaryTreePaths(root.left);
		List<String> rightpaths = binaryTreePaths(root.right);

		for (String path : leftpaths) {
			paths.add(root.val + "->" + path);
		}

		for (String path : rightpaths) {
			paths.add(root.val + "->" + path);
		}

		return paths;
	}

}

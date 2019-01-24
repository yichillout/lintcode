package com.jasper.dfs;

public class ParentTreeNode {

	public int val;
	ParentTreeNode left;
	ParentTreeNode right;
	ParentTreeNode parent;

	public ParentTreeNode(int val) {
		this.val = val;
		left = right = parent = null;
	}

}

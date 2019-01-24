package com.jasper.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC474_LowestCommonAncestoII {

	/*
	 * @param root: The root of the tree
	 * 
	 * @param A: node in the tree
	 * 
	 * @param B: node in the tree
	 * 
	 * @return: The lowest common ancestor of A and B
	 */
	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {

		List<ParentTreeNode> pathA = getPath2Root(A);
		List<ParentTreeNode> pathB = getPath2Root(B);

		int indexA = pathA.size() - 1;
		int indexB = pathB.size() - 1;

		ParentTreeNode lowestCommonAncestor = null;
		while (indexA >= 0 && indexB >= 0) {
			if (pathA.get(indexA) != pathB.get(indexB)) {
				break;
			}
			lowestCommonAncestor = pathA.get(indexA);
			indexA--;
			indexB--;
		}

		return lowestCommonAncestor;
	}

	private List<ParentTreeNode> getPath2Root(ParentTreeNode node) {
		List<ParentTreeNode> path = new ArrayList<>();
		while (node != null) {
			path.add(node);
			node = node.parent;
		}
		return path;
	}

}

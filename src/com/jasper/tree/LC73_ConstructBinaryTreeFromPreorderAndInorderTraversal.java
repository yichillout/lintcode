package com.jasper.tree;

import com.jasper.dfs.TreeNode;

public class LC73_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	// pre: root (left) (right)
	// in : (left) root (right)
	// post : (left) (right) root
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length)
			return null;
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		// if(preStart > preEnd) //都可以
		if (inStart > inEnd)
			return null;

		TreeNode node = new TreeNode(preorder[preStart]);
		int index = getIndex(inorder, inStart, inEnd, preorder[preStart]);

		node.left = helper(preorder, preStart + 1, preStart + (index - inStart), inorder, inStart, index - 1);
		node.right = helper(preorder, preStart + (index - inStart) + 1, preEnd, inorder, index + 1, inEnd);

		return node;
	}

	private int getIndex(int[] inorder, int inStart, int inEnd, int target) {
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == target) {
				return i;
			}
		}
		return -1;
	}
}

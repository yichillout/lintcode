package com.jasper.dfs;

import java.util.Stack;

public class LC453_FlattenBinaryTreeToLinkedList {

	TreeNode lastNode;

	// Version 1: Traverse
	public void flatten1(TreeNode root) {

		if (root == null)
			return;

		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}

		lastNode = root;
		TreeNode right = root.right;

		flatten1(root.left);
		flatten1(right);

	}
	
	// version 2: Divide & Conquer
	public void flatten2(TreeNode root) {
        helper(root);
    }
    
    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLast != null) {
            return rightLast;
        }
        
        if (leftLast != null) {
            return leftLast;
        }
        
        return root;
    }
    
    // version 3: Non-Recursion
    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            
            // connect 
            node.left = null;
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }
}

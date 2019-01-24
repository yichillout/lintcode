package com.jasper.dfs;

public class LC88_LowestCommonAncestorOfBinaryTree {
	/*
	 * @param root: The root of the binary search tree.
	 * 
	 * @param A: A TreeNode in a Binary.
	 * 
	 * @param B: A TreeNode in a Binary.
	 * 
	 * @return: Return the least common ancestor(LCA) of the two nodes.
	 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if(root == null || root == node1 || root == node2)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        
        if(left != null && right != null)
            return root;
        
        if(left != null)
            return left;
            
        if(right != null)
            return right;
        
        return null;
    }
}

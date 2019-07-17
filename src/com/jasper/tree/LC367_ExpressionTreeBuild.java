package com.jasper.tree;

class ExpressionTreeNode {
	public String symbol;
	public ExpressionTreeNode left, right;

	public ExpressionTreeNode(String symbol) {
		this.symbol = symbol;
		this.left = this.right = null;
	}
}

public class LC367_ExpressionTreeBuild {

	// Solution 1
	private ExpressionTreeNode buildTree1(String[] expression, int l, int r) {
		if (l == r) {
			ExpressionTreeNode node = new ExpressionTreeNode(expression[l]);
			return node;
		}

		int index = -1;
		while (l < r) {
			int index0 = -1;
			int index1 = -1;
			int counter = 0;

			for (int i = r; i >= l; i--) {
				if (expression[i].equals(")")) {
					counter++;
				}
				if (expression[i].equals("(")) {
					counter--;
				}
				if ((expression[i].equals("+") || expression[i].equals("-")) && counter == 0 && index0 == -1) {
					index0 = i;
				}
				if ((expression[i].equals("*") || expression[i].equals("/")) && counter == 0 && index1 == -1) {
					index1 = i;
				}
			}
			index = index0 == -1 ? index1 : index0;
			if (index != -1) {
				break;
			}
			l++;
			r--;
		}

		if (index != -1) {
			ExpressionTreeNode node = new ExpressionTreeNode(expression[index]);
			node.left = buildTree1(expression, l, index - 1);
			node.right = buildTree1(expression, index + 1, r);
			return node;
		} else if (l == r) {
			ExpressionTreeNode node = new ExpressionTreeNode(expression[l]);
			return node;
		} else {
			return null;
		}
	}

	public ExpressionTreeNode build(String[] expression) {
		return buildTree1(expression, 0, expression.length - 1);
	}

}

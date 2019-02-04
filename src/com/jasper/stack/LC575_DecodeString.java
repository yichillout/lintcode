package com.jasper.stack;

import java.util.Stack;

/* 
 * Example
 * s = abc3[a] return abcaaa
 * s = 3[abc] return abcabcabc
 * s = 4[ac]dy, return acacacacdy
 */

public class LC575_DecodeString {

	public String expressionExpand(String s) {
		Stack<Object> stack = new Stack<>();
		int number = 0;

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				number = number * 10 + c - '0';
			} else if (c == '[') {
				stack.push(Integer.valueOf(number));
				number = 0;
			} else if (c == ']') {
				String newStr = popStack(stack);
				Integer count = (Integer) stack.pop();
				for (int i = 0; i < count; i++) {
					stack.push(newStr);
				}
			} else {
				stack.push(String.valueOf(c));
			}
		}

		return popStack(stack);
	}

	private String popStack(Stack<Object> stack) {
		// pop stack until get a number or empty
		Stack<String> buffer = new Stack<>();
		while (!stack.isEmpty() && (stack.peek() instanceof String)) {
			buffer.push((String) stack.pop());
		}

		StringBuilder sb = new StringBuilder();
		while (!buffer.isEmpty()) {
			sb.append(buffer.pop());
		}
		return sb.toString();
	}

}

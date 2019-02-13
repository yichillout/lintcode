package com.jasper.sort;

public class LC49_SortLettersByCase {

	public void sortLetters(char[] chars) {
		if (chars == null || chars.length == 0)
			return;

		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLowerCase(chars[i])) {
				swap(chars, j, i);
				j++;
			}
		}
	}

	private void swap(char[] chars, int x, int y) {
		char tmp = chars[x];
		chars[x] = chars[y];
		chars[y] = tmp;
	}

}

package com.jasper.sort;

class FlipTool {

	public static void flip(int[] array, int index) {

	}

}

public class LC894_PancakeSorting {

	public void pancakeSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int length = array.length - 1;
		int max = array[0];
		int maxIndex = 0;
		while (length >= 1) {
			for (int i = 0; i <= length; i++) {
				if (max < array[i]) {
					max = array[i];
					maxIndex = i;
				}
			}
			FlipTool.flip(array, maxIndex);
			FlipTool.flip(array, length);
			length--;
			max = array[0];
			maxIndex = 0;
		}
	}
}

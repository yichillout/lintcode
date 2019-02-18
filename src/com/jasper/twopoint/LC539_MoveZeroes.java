package com.jasper.twopoint;

//***Template***
public class LC539_MoveZeroes {

	// 假设write的操作十分的花时间

	// 1 0 3 0 4 step 0
	// 1 3 0 0 4 step 1
	// 1 3 4 0 0 setp 3
	// 在这里swap的时候, 有没有必要把3那个地方改写成0呢? 其实没必要, 因为后面的数有可能会覆盖

	// Solution 1 : 同向双指针 -> 能保持原来的顺序
	public void moveZeroes1(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, index, i);
				index++;
			}
		}
	}

	private void swap(int[] nums, int x, int y) {
		int tmp = nums[x];
		nums[x] = nums[y];
		nums[y] = tmp;
	}

	// 1 0 3 0 4 step 0
	// 1 4 3 0 0 step 1
	// Solution 2 : 相向双指针 -> 让write操作比较少
	// 此答案在lintcode上不能通过
	public void moveZeroes2(int[] nums) {

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			while (start < end && nums[start] != 0) {
				start++;
			}
			while (start < end && nums[end] == 0) {
				end--;
			}
			if (start < end) {
				swap(nums, start, end);
			}
		}

	}

}

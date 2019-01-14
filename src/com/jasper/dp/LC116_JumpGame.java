package com.jasper.dp;

public class LC116_JumpGame {

	/**
	 * @param A: A list of integers
	 * @return: A boolean
	 */
	public boolean canJump(int[] A) {
		
		// 如果要用到n+1就开n+1,根据题目要求来开空间
		boolean[] f = new boolean[A.length];

		f[0] = true;

		for (int j = 1; j < f.length; j++) {
			f[j] = false; // init to false
			for (int i = 0; i < A.length; i++) {
				if (f[i] == true && i + A[i] >= j) {
					//f[j] |= f[i];
					f[j] = true;
					break;
				}
			}
		}

		return f[f.length - 1];
	}

}

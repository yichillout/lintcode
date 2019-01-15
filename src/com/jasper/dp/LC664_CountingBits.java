package com.jasper.dp;

public class LC664_CountingBits {

	public int[] countBits(int num) {
		int[] f = new int[num + 1];
		f[0] = 0;

		for (int i = 1; i <= num; i++) {
			f[i] = f[i>>1] + i%2;
            //f[i] = f[i/2] + i%2;
		}
		
		return f;
	}
}
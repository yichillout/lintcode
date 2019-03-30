package com.jasper.greedy;

public class LC150_BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
		int res = 0;
		int i;
		for (i = 0; i < prices.length - 1; i++) {
			res += Math.max(0, prices[i + 1] - prices[i]);
		}

		return res;
	}
}

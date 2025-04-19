package com.example.dsa.practice1.dp.buystock;

/**
 * ####  Buy and sell as many times it is feasible   #####
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the
 * stock at any time. However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 */
public class BuySellStockII {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, maxProfit - prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] + buy);
        }
        return maxProfit;
    }

}

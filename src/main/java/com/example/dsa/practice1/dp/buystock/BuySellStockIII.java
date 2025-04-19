package com.example.dsa.practice1.dp.buystock;

/**
 * ######   Buy and sell in at most 2 transaction   ######
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */
public class BuySellStockIII {

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int result = maxProfit(prices);
        assert result == 6;
        System.out.println("Result: " + result);
    }

    private static int maxProfit(int[] prices) {
        return maxProfit(prices, 2);
    }

    private static int maxProfit(int[] prices, int trans) {
        // 0 index = buy and 1 index profit;
        int[][] dp = new int[trans + 1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int i = trans; i > 0; i--) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] - price);
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + price);
            }
        }
        return dp[trans][1];
    }
}

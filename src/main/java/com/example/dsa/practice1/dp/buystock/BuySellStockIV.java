package com.example.dsa.practice1.dp.buystock;
/**
 * ######    Buy and sell at most k times    ######
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times
 * and sell at most k times.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * <p>
 * Example 2:
 * <p>
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BuySellStockIV {

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int result = maxProfit(2, prices);
        assert result == 7;
        System.out.println("Result: " + result);
    }

    private static int maxProfit(int k, int[] prices) {
        // buy at 0th index and profit at 1st index
        int[][] dp = new int[k + 1][2];
        for(int i = 0; i < dp.length;  i++){
            dp[i][0] = Integer.MIN_VALUE;
        }
        for(int price: prices){
            for(int i = k; i > 0; i--){
                dp[i][0] = Math.max(dp[i][0], dp[i-1][1] - price);
                dp[i][1] = Math.max(dp[i][1], dp[i][0] + price);
            }
        }
        return dp[k][1];
    }
}

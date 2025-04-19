package com.example.dsa.practice1.dp.buystock;
/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BuySellStockWithCoolingPeriod {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 4};
        int result = maxProfit(prices);
        System.out.println(result + "," + (result == 3));
        prices = new int[]{1, 2, 3, 0, 2};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit + "," + (maxProfit == 3));
    }

    private static int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, profit = 0, oldProfit = 0;
        for(int price: prices){
            int temp = profit;
            buy = Math.max(buy, oldProfit - price);
            profit = Math.max(profit, buy + price);
            oldProfit = temp;
        }
        return profit;
    }
}

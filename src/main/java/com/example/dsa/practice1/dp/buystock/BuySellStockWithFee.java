package com.example.dsa.practice1.dp.buystock;

public class BuySellStockWithFee {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        int result = maxProfit(prices, 3);
        System.out.println(result + "," + (result == 6));

    }

    private static int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE, profit = 0;
        for(int price: prices){
            buy = Math.max(buy, profit - price);
            profit = Math.max(profit, buy + price - fee);
        }
        return profit;
    }
}

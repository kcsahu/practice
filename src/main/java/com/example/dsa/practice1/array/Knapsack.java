package com.example.dsa.practice1.array;
// Dynamic Programming
public class Knapsack {

    public static void main(String[] args) {
        int[] values = new int[]{1, 8, 22, 28, 18};
        int[] weights = new int[]{1, 3, 6, 7, 5};
        int maxWt = 11;
        int maxValue = knapsack(values, maxWt, weights);
        System.out.println("Result: " +maxValue);
        System.out.println(maxValue == 40);
    }

    private static int knapsack(int[] values, int capacity, int wts[]) {
        int len = values.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < len; i++) {
            for (int w = capacity; w >= wts[i]; w--) {
                dp[w] = Math.max(dp[w], values[i] + dp[w - wts[i]]);
            }
        }
        return dp[capacity];
    }
}

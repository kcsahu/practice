package com.example.dsa.practice1.dp.robber;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the
 * last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the
 * police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money
 * you can rob tonight without alerting the police.
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int result = rob(nums);
        System.out.println(result);

        nums = new int[]{10, 9, 3, 1, 7};
        result = rob(nums);
        System.out.println(result);

        result = rob(new int[]{2, 3, 2});
        System.out.println(result);
    }


    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int[][] dp = new int[len + 1][2];
        int maxRob1 = 0, maxRob2 = 0;
        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                dp[i][0] = Math.max(i >= 2 ? nums[i] + dp[i - 2][0] : nums[i],
                        i >= 3 ? nums[i] + dp[i - 3][0] : nums[i]);
                maxRob1 = Math.max(dp[i][0], maxRob1);
            }
            if (i > 0) {
                dp[i][1] = Math.max(i >= 2 ? nums[i] + dp[i - 2][1] : nums[i],
                        i >= 3 ? nums[i] + dp[i - 3][1] : nums[i]);
                maxRob2 = Math.max(dp[i][1], maxRob2);
            }
        }
        return Math.max(maxRob1, maxRob2);
    }

}

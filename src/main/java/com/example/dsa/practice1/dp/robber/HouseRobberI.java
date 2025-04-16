package com.example.dsa.practice1.dp.robber;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
 * can rob tonight without alerting the police.
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobberI {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int result = rob(nums);
        System.out.println("Result: " + result + " " + (result == 12));
    }

    private static int rob(int[] nums) {
        int len = nums.length;
        int maxRob = 0;
        for (int i = 0; i < len; i++) {
            nums[i] = Math.max(i >= 2 ? nums[i] + nums[i - 2] : nums[i],
                    i >= 3 ? nums[i] + nums[i - 3] : nums[i]);
            maxRob = Math.max(maxRob, nums[i]);
        }
        return maxRob;
    }
}

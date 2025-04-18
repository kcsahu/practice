package com.example.dsa.practice1.dp.jumpgame;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGameI {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean result = canJump(nums);
        assert result;
        System.out.println("Result " + result);

        nums = new int[]{3, 2, 1, 0, 4};
        result = canJump(nums);
        assert !result;
        System.out.println("Result " + result);
    }

    public static boolean canJump(int[] nums) {
        int maxJump = 0, jumpCapacity = 0;
        for (int i = 0; i < nums.length; i++) {
            jumpCapacity = Math.max(jumpCapacity, nums[i] + i);
            if (maxJump == i) {
                maxJump = jumpCapacity;
            }
            if (maxJump >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

package com.example.dsa.practice1.dp.jumpgame;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * <p>
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
 * if you are at nums[i], you can jump to any nums[i + j] where:
 * <p>
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can
 * reach nums[n - 1].
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.
 */
public class JumpGameII {

    public static void main(String[] args) {
        int result = minJump(new int[]{2, 3, 1, 1, 4});
        assert result == 1;
        System.out.println(result);
        result = minJump(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
        assert result == 2;
        System.out.println(result);
        int result2 = minJump(new int[]{7, 6, 9, 6, 9, 6, 9, 7});
        assert result2 == 2;
        System.out.println(result2);
    }

    private static int minJump(int[] nums) {
        int maxJump = 0, jumpCapacity = 0, jumpCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            jumpCapacity = Math.max(jumpCapacity, nums[i] + i);
            if (maxJump == i) {
                maxJump = jumpCapacity;
                jumpCounter++;
            }
            if (maxJump >= nums.length - 1) {
                return jumpCounter;
            }
        }
        return 0;
    }

}

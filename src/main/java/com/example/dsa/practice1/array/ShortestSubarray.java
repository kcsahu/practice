package com.example.dsa.practice1.array;

import java.util.Deque;
import java.util.LinkedList;

// Two pointers and Prefix-sum
// Array with integers
public class ShortestSubarray {

    public static void main(String[] args) {

        int[] nums = {17, 85, 93, -45, -21};
        int result = shortestSubarray(nums, 150);
        System.out.println(result + " " + (result == 2));
        int res = shortestSubarray(new int[]{2, 3, 1, 2, 4, 3}, 7);
        System.out.println("result = " + res + " " + (res == 2));
    }


    private static int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        long[] prefixSum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        Deque<Integer> dq = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < prefixSum.length; i++) {
            while (dq.size() > 0 && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - dq.pollFirst());
            }

            while (dq.size() > 0 && prefixSum[i] <= prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return minLen != Integer.MAX_VALUE ? minLen : -1;
    }


}

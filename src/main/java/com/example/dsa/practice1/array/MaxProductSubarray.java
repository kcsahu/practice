package com.example.dsa.practice1.array;

public class MaxProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProductSubarray(new int[]{2, 3, -2, 4, -3}));
    }

    public static int maxProductSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Or throw an exception, depending on requirements
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0]; // Keep track of the minimum product as well
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
            minSoFar = Math.min(nums[i], Math.min(maxSoFar * nums[i], minSoFar * nums[i]));

            maxSoFar = tempMax;
            result = Math.max(result, maxSoFar); // Update the overall maximum
        }

        return result;
    }
}

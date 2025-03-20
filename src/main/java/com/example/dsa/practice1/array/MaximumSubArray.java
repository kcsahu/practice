package com.example.dsa.practice1.array;

public class MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubarray(new int[]{-2,-4}));
        System.out.println(maxSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubarray(new int[]{5,4,-1,7,8}));
    }

    private static int maxSubarray(int[] nums){
        int maxSum = nums[0], curMaxSum = nums[0];
        for(int i=1; i< nums.length; i++){
            curMaxSum = Math.max(nums[i], curMaxSum + nums[i]);
            maxSum = Math.max(maxSum, curMaxSum);
        }
        return maxSum;
    }
}

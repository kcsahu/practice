package com.example.dsa.practice1.array;

public class MaxProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProductSubarray(new int[]{2, 3, -2, 4, -3}));
        System.out.println(maxProductSubarray(new int[]{2, 3, -2, -4, -3}));
    }

    public static int maxProductSubarray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for(int i=1; i < nums.length; i++){
            int curMax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            max = curMax;
            result = Math.max(result, max);
        }
        return result;
    }
}

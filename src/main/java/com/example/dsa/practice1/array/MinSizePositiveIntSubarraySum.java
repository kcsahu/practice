package com.example.dsa.practice1.array;
// Two pointers and Prefix-sum
// Array with only positive integers
public class MinSizePositiveIntSubarraySum {

    public static void main(String[] args) {
        int res = minSubArraySum(new int[]{2, 3, 1, 2, 4, 3}, 7);
        System.out.println("result = " + res);
        System.out.println(res == 2);
    }

    /**
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2  (4,3)
     */
    public static int minSubArraySum(int[] arr, int target) {
        int sum=0, minLen = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= target) {
                minLen = Math.min(minLen, i - j + 1);
                sum -= arr[j++];
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

}

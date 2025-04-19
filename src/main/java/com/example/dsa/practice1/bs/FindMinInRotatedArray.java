package com.example.dsa.practice1.bs;

/**
 * Find minimum in a sorted rotated array
 */
public class FindMinInRotatedArray {

    public static void main(String[] args) {
        int[] nums = {15, 17, 2, 4, 6, 8};
        int min = findMin(nums);
        System.out.println(min);
        assert min == 2;
    }

    private static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}

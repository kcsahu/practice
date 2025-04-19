package com.example.dsa.practice1.bs;

/**
 * Find min value in a sorted rotated array with duplicates
 */
public class FindMinInRotatedArrayWithDuplicates {
    public static void main(String[] args) {
        int min = findMin(new int[]{2, 2, 2, 0, 1, 1, 1, 1, 1});
        assert min == 0;
        System.out.println(min);

    }

    private static int findMin(int[] nums){
        int start = 0, end = nums.length - 1;
        while (start < end){
            int mid = start + ((end - start) >>> 1);
            if(nums[mid] > nums[end]){
                start = mid + 1;
            } else if(nums[mid] < nums[end]){
                end = mid;
            } else{
                end--;
            }
        }
        return start;
    }
}

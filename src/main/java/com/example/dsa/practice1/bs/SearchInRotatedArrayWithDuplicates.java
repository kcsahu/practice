package com.example.dsa.practice1.bs;

/**
 * Search the element in a sorted rotated array with duplicates.
 */
public class SearchInRotatedArrayWithDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 5, 6, 7, 7, 0, 1, 2};
        boolean result= search(new int[]{4, 5, 5, 6, 7, 7, 0, 1, 2}, 7);
        System.out.println(result);
//        Assert.isTrue(result, "Error");
    }

    private static boolean search(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        while (start < end){
            int mid = start + ((end - start)>>>1);
            if(nums[mid] == target){
                return true;
            } else if(nums[start] > nums[mid]){
                // left side array is sorted
                if(nums[start] >= target && target < nums[mid]){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            } else if( nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid -1;
                }
            } else if(nums[start] == nums[mid]) {
                start++;
            } else{
                end--;
            }
        }
        return false;
    }
}

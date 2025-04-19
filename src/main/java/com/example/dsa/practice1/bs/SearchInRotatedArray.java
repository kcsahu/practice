package com.example.dsa.practice1.bs;

/**
 * Search the targer element in the sorted rotated array
 */
public class SearchInRotatedArray {

    public static void main(String[] args) {
        int result = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        System.out.println(result);
        assert result == 4;
        result = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        System.out.println(result);
        assert result == -1;
        result = search(new int[]{1}, 3);
        assert result == -1;
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                // Left side array is sorted
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // Right side array is sorted.
                if (nums[mid] < target && target < nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

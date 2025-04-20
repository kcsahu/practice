package com.example.dsa.practice1.bs;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
 * target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */
public class FindFirstLastPositionInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] result = searchRange(nums, 8);
        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }
    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] result = new int[] { -1, -1 };
        boolean isFirstOccurrenceFound = false;
        while (start <= end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) {
                if (!isFirstOccurrenceFound) {
                    result[1] = mid;
                    end = mid - 1;
                    isFirstOccurrenceFound = true;
                } else {
                    result[0] = mid;
                    start = mid + 1;
                }
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}

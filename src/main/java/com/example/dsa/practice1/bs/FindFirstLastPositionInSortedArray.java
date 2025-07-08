package com.example.dsa.practice1.bs;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
 * target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */
public class FindFirstLastPositionInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 8, 8, 8, 10, 12};
        int[] result = searchRange(nums, 8);
        System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] result = new int[]{-1, -1};
        int occurrence = search(nums, start, end, target, true);
        if (occurrence != -1) {
            result[0] = occurrence;
            result[1] = search(nums, occurrence, end, target, false);
        }
        return result;
    }


    private static int search(int[] nums, int start, int end, int target, boolean searchLeft) {
        int firstOccurrence = -1;
        while (start <= end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) {
                firstOccurrence = mid;
                if (searchLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return firstOccurrence;
    }

}

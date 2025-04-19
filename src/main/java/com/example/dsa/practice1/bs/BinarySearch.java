package com.example.dsa.practice1.bs;

/**
 * Note: The input array should be sorted.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int search = search(new int[]{3, 5, 7, 9, 21, 39}, 21);
        System.out.println("Binary Search: " + search);
        int firstOccurrence = searchFirstOccurrence(new int[]{3, 3, 5, 7, 7, 9, 21, 21, 39}, 7);
        System.out.println("First occurrence: " + firstOccurrence);
        int lastOccurrence = searchLastOccurrence(new int[]{3, 3, 5, 7, 7, 9, 21, 21, 39}, 7);
        System.out.println("Last occurrence: " + lastOccurrence);
    }

    private static int searchFirstOccurrence(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int firstOccurrence = -1;
        while (start <= end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) {
                firstOccurrence = mid;
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return firstOccurrence;
    }

    private static int searchLastOccurrence(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int lastOccurrence = -1;
        while (start <= end) {
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) {
                lastOccurrence = mid;
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lastOccurrence;
    }

    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

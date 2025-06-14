package com.example.dsa.practice1.array;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers be
 * numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array
 * [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 */
public class TwoSumII {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        System.out.println(Arrays.stream(res).boxed().toList());
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            int index = search(numbers, i + 1, numbers.length - 1, diff);
            if (index != -1) {
                result[0] = i + 1;
                result[1] = index + 1;
                return result;
            }
        }
        return result;
    }

    private static int search(int[] numbers, int start, int end, int target) {
        if (start < numbers.length) {
            while (start <= end) {
                int mid = start + ((end - start) >>> 1);
                if (numbers[mid] == target) {
                    return mid;
                } else if (target < numbers[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

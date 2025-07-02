package com.example.dsa.practice1.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Array with unique integers.
 */
public class TwoSum {

    public static void main(String[] args) {
        var result = twoSumHashing(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.stream(result).mapToObj(Integer::valueOf).collect(Collectors.toList()));
        result = twoSumHashing(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.stream(result).mapToObj(Integer::valueOf).collect(Collectors.toList()));

        var result1 = twoSumHashing1(new int[]{3, 2, 4, 0, 1, 5, 6}, 6);
        System.out.println(result1);

    }


    private static int[] twoSumHashing(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> dict = new HashMap();
        for (int i = 0; i < len; i++) {
            int diff = target - nums[i];
            if(dict.containsKey(diff)){
                return new int[]{i, dict.get(diff)};
            } else{
                dict.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    // Returns all the possible combination.
    private static List<List<Integer>> twoSumHashing1(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> dict = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int diff = target - nums[i];
            if (dict.containsKey(diff)) {
                result.add(Stream.of(i, dict.get(diff)).toList());
            } else{
                dict.put(nums[i], i);
            }
        }
        return result;
    }


}

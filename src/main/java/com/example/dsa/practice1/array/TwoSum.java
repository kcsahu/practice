package com.example.dsa.practice1.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoSum {

    public static void main(String[] args) {
        int[] result = twoSumHashing(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.stream(result).mapToObj(Integer::valueOf).collect(Collectors.toList()));
        result = twoSumHashing(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.stream(result).mapToObj(Integer::valueOf).collect(Collectors.toList()));

    }


    private static int[] twoSumHashing(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> dict = new HashMap();
        for (int i = 0; i < len; i++) {
            dict.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            int diff = target - nums[i];
            Integer nextInd = dict.get(diff);
            if (nextInd != null && nextInd != i) {
                return new int[]{i, nextInd};
            }
        }
        return new int[]{};

    }


}

package com.example.dsa.practice1.backtracking;

import java.util.*;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible
 * unique permutations in any order.
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class PermutationII {

    public static void main(String[] args) {


    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new LinkedList<>();
        }
        Deque<State> dq = new LinkedList();
        dq.offer(new State(new LinkedList(), new boolean[len]));
        Set<List<Integer>> result = new LinkedHashSet<>();
        while (dq.size() > 0) {
            State curState = dq.poll();
            List<Integer> curPermutation = curState.permutation;
            boolean[] hasUsed = curState.hasUsed;
            if (curPermutation.size() == len) {
                result.add(curPermutation);
            }
            for (int i = 0; i < len; i++) {
                if (!hasUsed[i]) {
                    List<Integer> nextPermutation = new LinkedList(curPermutation);
                    boolean[] nextHasUsed = Arrays.copyOf(hasUsed, hasUsed.length);
                    nextPermutation.add(nums[i]);
                    nextHasUsed[i] = true;
                    dq.offer(new State(nextPermutation, nextHasUsed));
                }
            }
        }
        return new LinkedList(result);
    }

    private static class State {
        List<Integer> permutation;
        boolean[] hasUsed;

        State(List<Integer> permutation, boolean[] hasUsed) {
            this.permutation = permutation;
            this.hasUsed = hasUsed;
        }
    }
}

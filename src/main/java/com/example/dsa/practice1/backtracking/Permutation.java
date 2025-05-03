package com.example.dsa.practice1.backtracking;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutation {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new LinkedList();
        }
        Deque<State> dq = new LinkedList();
        dq.offer(new State(new LinkedList(), new boolean[len]));
        List<List<Integer>> result = new LinkedList();
        while (dq.size() > 0) {
            State curState = dq.poll();
            List<Integer> curPermutation = curState.permutation;
            boolean[] curHasUsed = curState.hasUsed;
            if (curPermutation.size() == len) {
                result.add(curPermutation);
            }
            for (int i = 0; i < len; i++) {
                if (!curHasUsed[i]) {
                    List<Integer> nextPermutation = new LinkedList(curPermutation);
                    nextPermutation.add(nums[i]);
                    boolean[] nextHasUsed = Arrays.copyOf(curHasUsed, curHasUsed.length);
                    nextHasUsed[i] = true;
                    dq.offer(new State(nextPermutation, nextHasUsed));
                }
            }
        }
        return result;
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

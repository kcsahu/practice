package com.example.dsa.practice1.backtracking;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationOfString {

    public static void main(String[] args) {
        var result = permute("123");
        System.out.println(result);
        result = permute("abc");
        System.out.println(result);
        result = permute("112");
        System.out.println(result);
    }

    private static class State<T> {
        List<T> permutation;
        boolean[] hasVisited;

        State(List<T> permutation, boolean[] hasVisited) {
            this.permutation = permutation;
            this.hasVisited = hasVisited;
        }
    }

    private static List<String> permute(String value) {
        char[] arr = value.toCharArray();
        int len = arr.length;
        if (len == 0) {
            return new LinkedList<>();
        }
        Deque<State<Character>> deque = new LinkedList<>();
        deque.offer(new State<Character>(new LinkedList(), new boolean[len]));
        List<String> result = new LinkedList<>();
        while (deque.size() > 0) {
            State<Character> element = deque.poll();
            List<Character> curPermutation = element.permutation;
            boolean[] hasUsed = element.hasVisited;
            if (curPermutation.size() == 3) {
                result.add(curPermutation.stream().map(String::valueOf).collect(Collectors.joining()));
            }
            for (int i = 0; i < len; i++) {
                if (!hasUsed[i]) {
                    List<Character> nextPermutation = new LinkedList<>(curPermutation);
                    nextPermutation.add(arr[i]);
                    boolean[] nextUsed = Arrays.copyOf(hasUsed, hasUsed.length);
                    nextUsed[i] = true;
                    deque.offer(new State<>(nextPermutation, nextUsed));
                }
            }
        }
        return result;
    }


}

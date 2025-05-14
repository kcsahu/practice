package com.example.dsa.practice1.backtracking;

import java.util.LinkedList;
import java.util.List;

public class PermutationOfStringI {

    public static void main(String[] args) {
        String value = "abc";
        System.out.println(permutation(value));
        System.out.println("Iteration" + iteration);
    }

    static int iteration = 0;
    private static List<String> permutation(String value) {
        List<String> result = new LinkedList<>();
        permute(value.toCharArray(), 0, result);
        return result;
    }

    private static void permute(char[] arr, int pos, List<String> result) {
        if (pos == arr.length - 1) {
            result.add(new String(arr));
            return;
        }
        for (int i = pos; i < arr.length; i++) {
            swap(arr, i, pos);
            permute(arr, pos + 1, result);
            swap(arr, i, pos);
            iteration++;
        }
    }

    private static void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

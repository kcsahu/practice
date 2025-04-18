package com.example.dsa.practice1.dp.jumpgame;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array.
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
 *
 * Notice that you can not jump outside the array at any time.
 *
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation:
 * All possible ways to reach at index 3 with value 0 are:
 * index 5 -> index 4 -> index 1 -> index 3
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3
 *
 */
public class JumpGameIII {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,3,0,3,1,2};
        boolean result = canReach(arr, 5);
        assert result;
        System.out.println(result);

        arr = new int[]{3,0,2,1,2};
        result = canReach(arr, 2);
        assert !result;
        System.out.println(result);
    }


    public static boolean canReach(int[] arr, int start) {
        int len = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] hasVisited = new boolean[len];
        while (queue.size() >0){
            int pos = queue.poll();
            if(arr[pos] == 0){
                return true;
            }
            int nextPos = pos + arr[pos];
            if(nextPos < len && !hasVisited[nextPos]){
                queue.offer(nextPos);
                hasVisited[nextPos] = true;
            }
            int prevPos = pos - arr[pos];
            if(prevPos >= 0 && !hasVisited[prevPos]){
                queue.offer(prevPos);
                hasVisited[prevPos] = true;
            }
        }
        return false;
    }
}

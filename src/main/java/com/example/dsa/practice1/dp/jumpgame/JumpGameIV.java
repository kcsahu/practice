package com.example.dsa.practice1.dp.jumpgame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * <p>
 * In one step you can jump from index i to index:
 * <p>
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 * <p>
 * Notice that you can not jump outside the array at any time.
 * <p>
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 */
public class JumpGameIV {

    public static void main(String[] args) {
        int result = minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404});
        assert result == 3;
        System.out.println(result);
        int result2 = minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7});
        assert result2 == 1;
        System.out.println(result2);
    }

    public static int minJumps(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return 0;
        }
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Queue<Integer> indices = map.computeIfAbsent(arr[i], v -> new LinkedList<>());
            indices.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] hasVisited = new boolean[len];
        Map<Integer, Integer> counterMap = new HashMap<>();
        counterMap.put(0, 0);
        while (queue.size() > 0) {
            int pos = queue.poll();
            int jumpCounter = counterMap.get(pos);
            if (pos == len - 1) {
                return jumpCounter;
            }
            Queue<Integer> indices = map.get(arr[pos]);
            while (indices.size() > 0) {
                int nextIndex = indices.poll();
                if (!hasVisited[nextIndex]) {
                    queue.offer(nextIndex);
                    hasVisited[nextIndex] = true;
                    counterMap.put(nextIndex, jumpCounter + 1);
                }
            }

            int nextPos = pos + 1;
            if (nextPos < len && !hasVisited[nextPos]) {
                queue.offer(nextPos);
                hasVisited[nextPos] = true;
                counterMap.put(nextPos, jumpCounter + 1);
            }
            int prevPos = pos - 1;
            if (prevPos >= 0 && !hasVisited[prevPos]) {
                queue.offer(prevPos);
                hasVisited[prevPos] = true;
                counterMap.put(prevPos, jumpCounter + 1);
            }
        }
        return 0;
    }

}

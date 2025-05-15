package com.example.dsa.practice1.backtracking;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 */
public class NQueensII {

    public static void main(String[] args) {
        int totalQueens = totalNQueens(4);
        System.out.println("result: " + totalQueens);
        System.out.println(2 == totalQueens);
        totalQueens = totalNQueens(8);
        System.out.println("result: " + totalQueens);
        System.out.println(92 == totalQueens);
    }


    private static int totalNQueens(int n){
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        AtomicInteger totalQueens = new AtomicInteger();
        solve(0, n, queens, totalQueens);
        return totalQueens.get();
    }

    private static boolean isValid(int row, int col, int[] queens){
        for(int prevRow = 0; prevRow < row; prevRow++){
            int prevCol = queens[prevRow];
            if(prevCol == col || (Math.abs(col - prevCol) == Math.abs(row - prevRow))){
                return false;
            }
        }
        return true;
    }

    private static void solve(int row, int n, int[] queens, AtomicInteger totalQueens){
        if(row == n){
            totalQueens.incrementAndGet();
            return;
        }
        for(int col = 0; col < n; col++){
            if(isValid(row, col, queens)){
                queens[row] = col;
                solve(row + 1, n, queens, totalQueens);
                queens[row] = -1;
            }
        }
    }
}

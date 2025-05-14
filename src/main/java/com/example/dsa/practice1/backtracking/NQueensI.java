package com.example.dsa.practice1.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both
 * indicate a queen and an empty space, respectively.
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class NQueensI {

    public static void main(String[] args) {
        var res = solveNQueens(4);
        System.out.println(res);
    }

    private static List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> result = new LinkedList<>();
        solve(0, n, queens, result);
        return result;
    }

    private static boolean isValid(int row, int col, int[] queens) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];
            if (col == prevCol || (Math.abs(col - prevCol) == Math.abs(row - prevRow))) {
                return false;
            }
        }
        return true;
    }

    private static List<String> generateBoard(int n, int[] queens) {
        List<String> board = new LinkedList<>();
        for (int row = 0; row < n; row++) {
            char[] values = new char[n];
            Arrays.fill(values, '.');
            values[queens[row]] = 'Q';
            board.add(new String(values));
        }
        return board;
    }

    private static void solve(int row, int n, int[] queens, List<List<String>> result) {
        if (row == n) {
            result.add(generateBoard(n, queens));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, queens)) {
                queens[row] = col;
                solve(row + 1, n, queens, result);
                // backtrack
                queens[row] = -1;
            }
        }
    }


}

package com.example.dsa.practice1.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 */
public class WordSearchII {

    public static void main(String[] args) {
        WordSearchII obj = new WordSearchII();
        char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        String[] words = new String[]{"oa", "oaa"};
        var res = obj.findWords(board, words);
        System.out.println(res);
    }

    private static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isEnd;
        String word;

        public TrieNode() {
            this.child = new HashMap<>();
            this.isEnd = false;
        }
    }

    private TrieNode root = new TrieNode();

    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.child.containsKey(c)) {
                    node = node.child.get(c);
                } else {
                    node = node.child.computeIfAbsent(c, val -> new TrieNode());
                }
            }
            node.isEnd = true;
            node.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (root.child.containsKey(board[row][col])) {
                    solve(board, row, col, root, result);
                }
            }
        }
        return result;
    }

    public boolean solve(char[][] board, int row, int col, TrieNode node, List<String> result) {
        if (node.isEnd) {
            result.add(node.word);
            node.isEnd = false;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        node = node.child.get(temp);
        boolean isFound = false;
        if (node != null) {
            isFound = solve(board, row + 1, col, node, result) ||
                    solve(board, row - 1, col, node, result) ||
                    solve(board, row, col + 1, node, result) ||
                    solve(board, row, col - 1, node, result);
        }
        board[row][col] = temp;
        return isFound;
    }

}

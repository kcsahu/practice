package com.example.dsa.practice1.word;

import java.util.*;
import java.util.stream.Stream;

/**
 * ####    BFS BACKTRACKING    ####
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence
 * of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * <p>
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation
 * sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be
 * returned as a list of the words [beginWord, s1, s2, ..., sk].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 */
public class WordLadderII {

    public static void main(String[] args) {
        List<List<String>> result = findLadders("hit", "cog", new ArrayList<>(
                Stream.of("hot", "dot", "dog", "lot", "log", "cog").toList()));
        System.out.println(result);
        var result4 = findLadders("red", "tax",
                new ArrayList<>(Stream.of("ted", "tex", "red", "tax", "tad", "den", "rex", "pee").toList()));
        System.out.println(result4);
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        Queue<State> queue = new LinkedList<>();
        List<String> ladders = new LinkedList<>();
        ladders.add(beginWord);
        queue.offer(new State(beginWord, ladders, new boolean[len]));
        List<List<String>> result = new LinkedList<>();
        int minSize = Integer.MAX_VALUE;
        while (queue.size() > 0) {
            State curState = queue.poll();
            List<String> curLadders = curState.ladders;
            boolean[] curVisited = curState.hasVisited;
            if (endWord.equals(curState.word) && curState.ladders.size() <= minSize) {
                result.add(curState.ladders);
                minSize = curState.ladders.size();
            }
            for (int i = 0; i < len; i++) {
                String nextWord = wordList.get(i);
                if (!curVisited[i] && isAdjacent(curState.word, nextWord)) {
                    List<String> nextLadders = new LinkedList<>(curLadders);
                    nextLadders.add(nextWord);
                    boolean[] nextVisited = Arrays.copyOf(curVisited, curVisited.length);
                    nextVisited[i] = true;
                    queue.offer(new State(nextWord, nextLadders, nextVisited));
                }
            }
        }
        return result;
    }

    private static class State {
        String word;
        List<String> ladders;
        boolean[] hasVisited;

        State(String word, List<String> ladders, boolean[] hasVisited) {
            this.word = word;
            this.ladders = ladders;
            this.hasVisited = hasVisited;
        }
    }


    private static boolean isAdjacent(String word1, String word2) {
        int len = word1.length();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                diff++;
            }
        }
        return diff == len - 1;
    }


}

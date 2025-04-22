package com.example.dsa.practice1.word;

import java.util.*;
import java.util.stream.Stream;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
 * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 */
public class WordLadder {

    public static void main(String[] args) {
        int result = ladderLength("hit", "cog", new ArrayList<>(
                Stream.of("hot", "dot", "dog", "lot", "log", "cog").toList()));
        System.out.println(result);
        assert 5 == result;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> dq = new LinkedList<>();
        dq.push(beginWord);
        Map<String, Integer> lengthCounter = new HashMap<>();
        lengthCounter.put(beginWord, 1);
        while (dq.size() > 0) {
            String word = dq.poll();
            int length = lengthCounter.get(word);
            if (endWord.equals(word)) {
                return length;
            }
            Iterator<String> itr = wordList.iterator();
            while(itr.hasNext()){
                String nextWord = itr.next();
                if (isAdjacent(word, nextWord)) {
                    dq.push(nextWord);
                    lengthCounter.put(nextWord, length + 1);
                    itr.remove();
                }
            }
        }
        return 0;
    }

    private static boolean isAdjacent(String word1, String word2) {
        int len = word1.length();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                diff++;
            }
        }
        return diff >= len - 1;
    }
}

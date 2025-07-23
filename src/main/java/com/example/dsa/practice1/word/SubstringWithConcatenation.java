package com.example.dsa.practice1.word;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * #####   Sliding window   #########
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
 * "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 * Example 1:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation:
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 */
public class SubstringWithConcatenation {

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"bar", "foo"})); // [0,9]
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(findSubstring("barfoobarfoobarman", new String[]{"bar", "foo"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int totalLength = words[0].length() * words.length;
        List<Integer> result = new LinkedList();
        String prevString = null;
        for (int i = 0; i + totalLength < s.length() + 1; i++) {
            String substring = s.substring(i, i + totalLength);
            if (substring.equals(prevString) || isSubstring2(substring, words)) {
                result.add(i);
                prevString = substring;
            }
        }
        return result;
    }

    private static boolean isSubstring(String s, String[] words) {
        PriorityQueue<String> dict = new PriorityQueue<>(Arrays.stream(words).toList());
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dp[j] && dict.contains(substring)) {
                    dp[i] = true;
                    dict.remove(substring);
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private static boolean isSubstring2(String s, String[] words) {
        PriorityQueue<String> dict = new PriorityQueue<>(Arrays.stream(words).toList());
        int size = words[0].length();
        for (int i = 0; i < s.length(); i = i + size) {
            String substring = s.substring(i, i + size);
            if (dict.contains(substring)) {
                dict.remove(substring);
            } else {
                return false;
            }
        }
        return dict.size() == 0;
    }

}

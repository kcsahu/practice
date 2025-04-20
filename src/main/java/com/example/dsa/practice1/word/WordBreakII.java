package com.example.dsa.practice1.word;

import java.util.*;
import java.util.stream.Stream;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is
 * a valid dictionary word.
 * Return all such possible sentences in any order.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 */
public class WordBreakII {

    public static void main(String[] args) {
        List<String> res = wordBreak("catsanddog", Stream.of("cat", "cats", "and", "dog", "sand").toList());
        System.out.println(res + ": " + (res.equals(Stream.of("cat sand dog", "cats and dog").toList())));
        res = wordBreak("pineapplepenapple", Stream.of("apple", "pen", "applepen", "pine", "pineapple").toList());
        System.out.println(res + ": " + res.equals(Stream.of("pine apple pen apple", "pine applepen apple", "pineapple pen apple").toList()));
        res = wordBreak("catsandog", Stream.of("cat", "cats", "and", "dog", "sand").toList());
        System.out.println(res + ": " + Collections.emptyList().equals(res));
    }


    private static List<String> wordBreak(String s, List<String> wordDict){
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> wordContainer = new HashMap<>();
        List<String> result = wordBreak(s, dict, wordContainer);
        return result;
    }

    private static List<String> wordBreak(String s, Set<String> dict, Map<String, List<String>> resultMap){
        if(resultMap.containsKey(s)){
            return resultMap.get(s);
        }
        int len = s.length();
        List<String> words = resultMap.computeIfAbsent(s, v-> new LinkedList<String>());
        for(int i=0, j=1; j<len; j++){
            if(dict.contains(s.substring(i, j))){
                String prefix = s.substring(i, j);
                String suffix = s.substring(j);
                List<String> result = wordBreak(suffix, dict, resultMap);
                for(String word : result){
                    words.add(prefix +" " + word);
                }
            }
        }
        if(dict.contains(s)){
            words.add(s);
        }
        return words;
    }
}

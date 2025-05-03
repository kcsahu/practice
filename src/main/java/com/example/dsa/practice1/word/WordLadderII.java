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
        result = findLadders("cet", "ism", new ArrayList<>(Stream.of("kid","tag","pup","ail"
                ,"tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar",
                "die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum",
                "ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis",
                "ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal",
                "lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san",
                "pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap",
                "owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob",
                "ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk",
                "far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don",
                "tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft",
                "inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub",
                "ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and",
                "ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey",
                "bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas",
                "pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw",
                "sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you",
                "its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog",
                "eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum",
                "hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit",
                "boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye",
                "hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad",
                "ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm",
                "nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod",
                "fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid",
                "sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt",
                "lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get",
                "gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins",
                "con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot",
                "del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim").toList()));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        Queue<State> queue = new LinkedList<>();
        List<String> ladders = new LinkedList<>();
        ladders.add(beginWord);
        queue.offer(new State(beginWord, ladders, new HashSet<>()));
        List<List<String>> result = new LinkedList<>();
        int minSize = Integer.MAX_VALUE;
        while (queue.size() > 0) {
            State curState = queue.poll();
            List<String> curLadders = curState.ladders;
            Set<Integer> curVisited = curState.hasVisited;
            if (endWord.equals(curState.word) && curState.ladders.size() <= minSize) {
                result.add(curState.ladders);
                minSize = curState.ladders.size();
                continue;
            }
            for (int i = 0; i < len; i++) {
                String nextWord = wordList.get(i);
                if (!curVisited.contains(i) && isAdjacent(curState.word, nextWord)) {
                    List<String> nextLadders = new LinkedList<>(curLadders);
                    nextLadders.add(nextWord);
                    Set<Integer> nextVisited = new HashSet<>(curVisited);
                    nextVisited.add(i);
                    queue.offer(new State(nextWord, nextLadders, nextVisited));
                }
            }
        }
        return result;
    }

    private static class State {
        String word;
        List<String> ladders;
        Set<Integer> hasVisited;

        State(String word, List<String> ladders, Set<Integer> hasVisited) {
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

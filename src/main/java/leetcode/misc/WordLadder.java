package leetcode.misc;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    Set<String> used = new HashSet();
    String ew;
    String bw;
    int min = Integer.MAX_VALUE;
    List<String> wordList;
    HashMap<String, Set<String>> map = new HashMap();
    HashMap<String, Integer> countMap = new HashMap<>();
    Set<String> failed = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ew = endWord;
        bw = beginWord;
        this.wordList = wordList;
        recurse(bw, 1);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    boolean differByOne(String word1, String word2) {

        Set<String> s = map.getOrDefault(word1, null);

        if (s != null && s.contains(word2)) {
            return true;
        }

        int change = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                change++;
        }

        if (change <= 1) {
            s = map.getOrDefault(word1, null);
            if (s == null) {
                s = new HashSet();
                map.put(word1, s);
            }
            s.add(word2);

            s = map.getOrDefault(word2, null);
            if (s == null) {
                s = new HashSet();
                map.put(word2, s);
            }
            s.add(word1);
        }

        return change <= 1;
    }

    Pair<Boolean, Integer> recurse(String trans, int count) {

        if (trans.equals(ew)) {
            min = Math.min(min, count);
            return new Pair(true, count);
        }

        if (countMap.containsKey(trans)) {
            return new Pair(true, count + countMap.get(trans));
        }

        for (String word : wordList) {
            if (!word.equals(bw) && differByOne(word, trans) && !used.contains(word)) {

                used.add(word);
                Pair<Boolean, Integer> res = recurse(word, count + 1);

                if (res.getKey()) {
                    countMap.put(word, res.getValue().intValue() - count);
                }

                used.remove(word);
            }
        }

        return new Pair<>(false, null);
    }

}

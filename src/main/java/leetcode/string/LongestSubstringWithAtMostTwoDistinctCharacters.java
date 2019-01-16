package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Runtime: 20 ms, faster than 27.71% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        Set<Character> seen = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap();

        int ws = 0;
        int we = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            char next = s.charAt(i);
            seen.add(next);
            map.put(next, map.getOrDefault(next, 0) + 1);
            we = i;

            while (seen.size() > 2) {
                char prev = s.charAt(ws);
                int count = map.get(prev);
                count--;
                if (count == 0) {
                    seen.remove(prev);
                    map.remove(prev);
                } else {
                    map.put(prev, count);
                }
                ws++;
            }

            max = Math.max(max, we - ws + 1);

        }

        return max;
    }

}

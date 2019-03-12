package leetcode.string;

import java.util.HashMap;

/**
 * Runtime: 17 ms, faster than 44.99% of Java online submissions for Longest Substring with At Most K Distinct Characters.
 */
public class LongestSubstringWithAtMostKDistinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int max = 0;

        if (s == null || s.length() == 0 || k <= 0)
            return max;

        HashMap<Character, Integer> seen = new HashMap<>();

        int i = 0;
        int st = 0;

        while (i < s.length()) {

            char ch = s.charAt(i);

            if (seen.containsKey(ch)) {
                seen.put(ch, seen.get(ch) + 1);

            } else {

                seen.put(ch, 1);

                // does it overshoot the distinct count
                while (seen.size() > k) {
                    ch = s.charAt(st);
                    int count = seen.get(ch);
                    if (count == 1)
                        seen.remove(ch);
                    else
                        seen.put(ch, count - 1);
                    st++;
                }
            }

            max = Math.max(i - st + 1, max);
            i++;
        }

        return max;
    }

}

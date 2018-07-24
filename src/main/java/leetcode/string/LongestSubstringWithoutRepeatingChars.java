package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    /**
     * Runtime: 30 ms, faster than 84.89% of Java online submissions for Longest Substring Without Repeating Characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        Set<Character> seen = new HashSet<Character>();
        int max = 0;
        int wStart = 0;
        int wEnd = 0;
        int curr = 0;

        while(wEnd < s.length()){

            Character c = (new Character(s.charAt(wEnd)));

            if(seen.contains(c)) {
                while(!c.equals(s.charAt(wStart))){
                    curr--;
                    seen.remove(s.charAt(wStart));
                    wStart++;
                }
                wStart++;
            } else {
                curr++;
                max = max < curr ? curr : max;
                seen.add(c);
            }

            wEnd++;
        }


        return max;
    }
}

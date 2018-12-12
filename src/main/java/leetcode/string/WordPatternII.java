package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Runtime: 49 ms, faster than 73.70% of Java online submissions for Word Pattern II.
 */
public class WordPatternII {

    HashMap<Character, String> map = new HashMap();
    Set<String> used = new HashSet();

    public boolean wordPatternMatch(String pattern, String str) {

        if (pattern.length() == 0 && str.length() == 0)
            return true;

        if (pattern.length() == 0 || str.length() == 0)
            return false;

        char c = pattern.charAt(0);

        if (map.containsKey(c)) {
            String match = map.get(c);
            if (str.indexOf(match) == 0) {
                return wordPatternMatch(pattern.substring(1), str.substring(match.length()));
            } else {
                return false;
            }

        } else {
            for (int j = 0; j < str.length(); j++) {

                String possibleMatch = str.substring(0, j + 1);
                if (!used.contains(possibleMatch)) {
                    map.put(c, possibleMatch);
                    used.add(possibleMatch);
                    if (wordPatternMatch(pattern.substring(1), str.substring(j + 1))) {
                        return true;
                    }
                    used.remove(possibleMatch);
                }
            }

            map.remove(c);
        }

        return false;
    }
}

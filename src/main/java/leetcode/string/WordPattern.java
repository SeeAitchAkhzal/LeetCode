package leetcode.string;

import java.util.HashMap;

public class WordPattern {

    /**
     * Runtime: 1 ms, faster than 99.08% of Java online submissions for Word Pattern.
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {

        String[] tokens = str.split(" ");
        HashMap<Character, String> map = new HashMap();
        HashMap<String, Character> map2 = new HashMap();

        if (tokens.length != pattern.length())
            return false;

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String tk = tokens[i];

            if (map.containsKey(c) && map2.containsKey(tk)) {
                if (!map.get(c).equals(tk) || !map2.get(tk).equals(c))
                    return false;
            } else if ((map.containsKey(c) && !map2.containsKey(tk)) ||
                       (!map.containsKey(c) && map2.containsKey(tk))) {
                return false;
            } else {
                map.put(c, tokens[i]);
                map2.put(tk, c);
            }
        }

        return true;

    }
}

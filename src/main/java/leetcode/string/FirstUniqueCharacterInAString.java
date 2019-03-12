package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Runtime: 90 ms, faster than 34.21% of Java online submissions for First Unique Character in a String.
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {

        Integer[] a = new Integer[3];
        List<Integer> l = Arrays.asList(a);

        HashMap<Character, Integer> map = new HashMap();

        if (s == null || "".equals(s))
            return -1;

        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1)
                return i;

        return -1;
    }

}

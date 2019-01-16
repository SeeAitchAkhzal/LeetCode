package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Runtime: 13 ms, faster than 96.89% of Java online submissions for Group Anagrams.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap();

        for (int i = 0; i < strs.length; i++) {

            String str = strs[i];

            char[] a = str.toCharArray();
            Arrays.sort(a);

            String key = new String(a);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {

                List<String> l = new ArrayList();
                l.add(str);
                map.put(key, l);
            }
        }

        List<List<String>> result = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
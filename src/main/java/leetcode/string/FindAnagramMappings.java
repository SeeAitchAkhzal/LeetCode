package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Runtime: 6 ms, faster than 45.99% of Java online submissions for Find Anagram Mappings.
 */
public class FindAnagramMappings {

    public int[] anagramMappings(int[] A, int[] B) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = B.length;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(B[i])) {
                map.get(B[i]).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(B[i], l);
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            int v = A[i];
            List<Integer> l = map.get(v);
            result[i] = l.get(0);
            l.remove(0);
        }

        return result;
    }
}

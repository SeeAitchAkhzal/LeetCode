package leetcode.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Runtime: 19 ms, faster than 61.10% of Java online submissions for Top K Frequent Elements.
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList();

        if (nums == null || nums.length == 0)
            return result;

        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {

            int n = nums[i];

            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        Set[] buckets = new HashSet[nums.length];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int n = entry.getKey();
            int rep = entry.getValue() - 1;

            if (buckets[rep] == null) {
                buckets[rep] = new HashSet();
                buckets[rep].add(n);
            } else {
                buckets[rep].add(n);
            }
        }

        for (int i = buckets.length - 1; i >= 0; i--) {

            if (buckets[i] != null) {
                result.addAll(buckets[i]);
                k -= buckets[i].size();
            }

            if (k == 0)
                break;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        return result;

    }
}

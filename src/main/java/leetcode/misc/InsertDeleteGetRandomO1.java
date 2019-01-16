package leetcode.misc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Runtime: 109 ms, faster than 22.84% of Java online submissions for Insert Delete GetRandom O(1).
 */
public class InsertDeleteGetRandomO1 {

    class RandomizedSet {

        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {

            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, arr.size());
            arr.add(val);

            return true;

        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {

            if (!map.containsKey(val))
                return false;

            int i = map.get(val);
            map.remove(val);

            int last = arr.size() - 1;

            if (i != last) {
                int lastVal = arr.get(last);
                arr.set(i, lastVal);
                map.put(lastVal, i);
            }

            arr.remove(last);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int i = (int) (Math.random() * arr.size());
            return arr.get(i);
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}

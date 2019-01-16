package leetcode.arrays;

import java.util.HashMap;

/**
 * Runtime: 17 ms, faster than 16.63% of Java online submissions for Longest Consecutive Sequence.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap();
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], -1);
        }

        for (int i = 0; i < nums.length; i++) {

            int curr = nums[i];
            int temp = curr;
            int count = 1;
            while (map.containsKey(curr + 1)) {

                int above = map.get(curr + 1);
                if (above != -1) {
                    count += above;
                    break;
                }

                curr = curr + 1;
                count++;
            }

            map.put(temp, count);

            if (count > best)
                best = count;
        }

        return best;
    }

}

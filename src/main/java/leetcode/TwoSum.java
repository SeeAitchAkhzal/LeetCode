package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                ans[0] = map.get(complement);
                ans[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}

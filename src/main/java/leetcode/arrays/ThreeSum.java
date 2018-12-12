package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * Runtime: 46 ms, faster than 87.39% of Java online submissions for 3Sum.
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> finalResult = new ArrayList();

        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> partial = twoSum(nums, i, target - nums[i]);

                if (partial.size() != 0) {
                    finalResult.addAll(partial);
                }
            }
        }

        return finalResult;
    }

    List<List<Integer>> twoSum(int[] arr, int skipIndex, int target) {

        int s = skipIndex + 1;
        int e = arr.length - 1;
        List<List<Integer>> result = new ArrayList();

        while (s < e) {

            int sum = arr[s] + arr[e];

            if (sum > target) {
                e--;
            } else if (sum < target) {
                s++;
            } else {
                // found a match
                List<Integer> sol = new ArrayList();
                int n1 = arr[s];
                int n2 = arr[e];
                sol.add(n1);
                sol.add(n2);
                sol.add(0 - n1 - n2);
                result.add(sol);

                while (s < e && arr[s] == n1 && arr[e] == n2) {
                    s++;
                    e--;
                }
            }
        }

        return result;

    }
}

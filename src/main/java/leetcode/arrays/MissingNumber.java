package leetcode.arrays;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        boolean[] seen = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            seen[nums[i]] = true;
        }

        int k = -1;
        for (int i = 0; i <= nums.length; i++) {
            if (!seen[i]) {
                k = i;
                break;
            }
        }
        return k;
    }
}

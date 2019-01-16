package leetcode.arrays;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Product Subarray.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int len = nums.length;

        int rp = 1;
        int max = nums[0];

        for (int i = 0; i < len; i++) {

            rp *= nums[i];
            max = Math.max(rp, max);
            if (rp == 0) {
                rp = 1;
            }
        }

        rp = 1;
        for (int i = len - 1; i >= 0; i--) {
            rp *= nums[i];
            max = Math.max(rp, max);
            if (rp == 0)
                rp = 1;
        }

        return max;
    }
}

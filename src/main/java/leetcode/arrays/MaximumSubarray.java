package leetcode.arrays;

public class MaximumSubarray {

    /**
     * Runtime: 9 ms, faster than 78.57% of Java online submissions for Maximum Subarray.
     */
    public int maxSubArray(int[] nums) {

        int bestSum = nums[0];
        int sum = bestSum;

        for (int i = 1; i < nums.length; i++) {

            int next = nums[i];

            if (sum <= 0 && next >= 0) {
                sum = next;
            } else if (sum <= 0 && next < 0) {
                sum = next;
            } else if (sum >= 0 && next < 0) {
                sum = sum + next > 0 ? sum + next : next;
            } else if (sum >= 0 && next >= 0) {
                sum += next;
            }
            bestSum = bestSum < sum ? sum : bestSum;
        }

        return bestSum;

    }

    public int maxSubArray_2ndWay(int[] nums) {

        int bestSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            int next = nums[i];

            if (sum >= 0) {
                sum += next;
            } else {
                sum = next;
            }

            bestSum = Math.max(bestSum, sum);
        }

        return bestSum;
    }
}

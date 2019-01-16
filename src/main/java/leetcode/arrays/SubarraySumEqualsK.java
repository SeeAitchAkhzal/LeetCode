package leetcode.arrays;

/**
 * Runtime: 210 ms, faster than 9.72% of Java online submissions for Subarray Sum Equals K.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        int s = 0;
        int e = 0;
        int len = nums.length;

        int rs = 0;
        int count = 0;
        int[] cumSum = new int[len];

        for (int i = 0; i < len; i++) {
            rs += nums[i];
            cumSum[i] = rs;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i - 1 >= 0) {
                    if (cumSum[j] - cumSum[i - 1] == k)
                        count++;
                } else {
                    if (cumSum[j] == k)
                        count++;
                }
            }
        }

        return count;
    }
}

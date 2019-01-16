package leetcode.arrays;

/**
 * Runtime: 17 ms, faster than 66.53% of Java online submissions for Trapping Rain Water.
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int sum = 0;
        int len = height.length;

        if (len == 0)
            return 0;

        int[] max = new int[len];

        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {

            max[i] = currMax;
            if (currMax < height[i])
                currMax = height[i];
        }

        currMax = height[len - 1];
        for (int i = len - 2; i > 0; i--) {

            if (currMax > height[i]) {
                int w = Math.min(max[i], currMax) - height[i];
                sum += w > 0 ? w : 0;
            }

            if (currMax < height[i])
                currMax = height[i];
        }

        return sum;
    }

}

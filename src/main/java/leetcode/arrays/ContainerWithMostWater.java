package leetcode.arrays;

/**
 * Runtime: 8 ms, faster than 91.45% of Java online submissions for Container With Most Water.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int max = -1;

        int s = 0;
        int e = height.length -1;


        while(s<e){

            int p = Math.min(height[s],height[e]) * (e-s);

            if(p > max) max = p;


            if(height[s] < height[e])
                s++;
            else{
                e--;
            }
        }


        return max;

    }

}

package leetcode.math;

/**
 * Runtime: 30 ms, faster than 23.60% of Java online submissions for Sqrt(x).
 */
public class Sqrt {

    public int mySqrt(int x) {

        if (x == 0)
            return 0;
        if (x <= 2)
            return 1;

        int s = 0;
        int e = Integer.MAX_VALUE;

        while (true) {

            int half = ((e - s) / 2) + s;

            if (half == x / half ||
                (half < x / half && (half + 1) > x / (half + 1)))
                return half;

            if (half > x / half)
                e = (half - 1);

            if (half < x / half)
                s = (half + 1);
        }
    }

}

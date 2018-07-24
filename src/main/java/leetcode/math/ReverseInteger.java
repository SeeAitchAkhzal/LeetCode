package leetcode.math;

public class ReverseInteger {

    /**
     * Runtime: 22 ms, faster than 91.70% of Java online submissions for Reverse Integer.
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        int mul = 10;
        double MAX = Integer.MAX_VALUE;
        double MIN = Integer.MIN_VALUE;

        while (x != 0) {

            int d = x % 10;

            // check if the multiplication would result in overflow
            if (x > 0 && (MAX / mul) < rev)
                return 0;

            if (x < 0 && (MIN / mul) > rev)
                return 0;

            rev = rev * mul;

            // check if the addition would result in overflow
            if (x > 0 && (MAX - rev) < d)
                return 0;

            if (x < 0 && (MIN - rev) > d)
                return 0;

            rev += d;
            x /= 10;
        }

        return rev;
    }
}

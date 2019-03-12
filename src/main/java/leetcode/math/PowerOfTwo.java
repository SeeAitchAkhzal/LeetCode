package leetcode.math;

/**
 * Runtime: 2 ms, faster than 86.85% of Java online submissions for Power of Two.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        if (n <= 0) return false;
        if(n == 1) return true;

        while(n != 1) {

            if(n % 2 != 0) return false;
            n = n / 2;
        }

        return true;
    }

}

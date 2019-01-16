package leetcode.misc;

/**
 * Runtime: 6 ms, faster than 58.31% of Java online submissions for Hamming Distance.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int dist = 0;

        while (x != 0 || y != 0) {

            int b1 = x % 2;
            int b2 = y % 2;

            x /= 2;
            y /= 2;

            if (b1 != b2)
                dist++;
        }

        return dist;

    }

}

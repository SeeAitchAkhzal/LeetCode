package leetcode.string;

/**
 * Runtime: 14 ms, faster than 79.04% of Java online submissions for Longest Palindromic Substring.
 */
public class LongestPalindrome {

    int ms = 0;
    int me = 0;

    public String longestPalindrome(String s) {

        if (s.length() == 0 || s.length() == 1)
            return s;

        for (int i = 0; i < s.length(); i++) {

            expand(i - 1, i + 1, s);
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {

                if (ms == 0 && me == 0) {
                    ms = i;
                    me = i + 1;
                }
                expand(i - 1, i + 2, s);
            }
        }

        return s.substring(ms, me + 1);

    }

    void expand(int l, int r, String s) {

        while (l >= 0 && r < s.length()) {

            if (s.charAt(l) == s.charAt(r)) {
                // update
                if (me - ms < r - l) {
                    me = r;
                    ms = l;
                }
            } else {
                break;
            }

            l--;
            r++;
        }
    }

}

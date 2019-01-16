package leetcode.misc;

/**
 * Runtime: 74 ms, faster than 20.87% of Java online submissions for Wildcard Matching.
 */

public class WildcardMatching {

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] tbl = new boolean[m + 1][n + 1];

        tbl[0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*' && tbl[0][i - 1])
                tbl[0][i] = true;
        }

        for (int i = 1; i < m + 1; i++) {
            char st = s.charAt(i - 1);
            for (int j = 1; j < n + 1; j++) {

                char pt = p.charAt(j - 1);

                if (st == pt || pt == '?') {
                    tbl[i][j] = tbl[i][j] || tbl[i - 1][j - 1];
                }

                if (pt == '*') {

                    tbl[i][j] = tbl[i][j] || tbl[i - 1][j - 1] ||
                                tbl[i][j - 1] || tbl[i - 1][j];
                }
            }
        }

        return tbl[m][n];
    }

}

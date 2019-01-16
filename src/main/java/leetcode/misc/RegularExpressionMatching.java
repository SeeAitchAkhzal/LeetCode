package leetcode.misc;

/**
 * Runtime: 25 ms, faster than 71.31% of Java online submissions for Regular Expression Matching.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] tbl = new boolean[m+1][n+1];

        tbl[0][0] = true;

        for(int k=1;k<n+1;k++) {

            char ch = p.charAt(k-1);
            if(ch == '*') tbl[0][k] = tbl[0][k-2];

        }

        for(int i =1;i<m+1;i++){
            char st = s.charAt(i-1);

            for(int j=1;j<n+1;j++){

                char pt = p.charAt(j-1);

                if(pt == st){
                    tbl[i][j] = tbl[i-1][j-1];
                }

                if(pt == '.'){
                    tbl[i][j] = tbl[i-1][j-1];
                }

                if(pt == '*'){

                    // taking zero preceding chars
                    if(tbl[i][j-2])
                        tbl[i][j] = true;

                    else if(p.charAt(j-2) == st || p.charAt(j-2) == '.'){
                        tbl[i][j] = tbl[i-1][j-2] || tbl[i-1][j];
                    }
                }
            }
        }

        return tbl[m][n];
    }

}

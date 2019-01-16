package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 2 ms, faster than 98.75% of Java online submissions for Spiral Matrix.
 */
public class SpiralMatrix {

    List<Integer> result = new ArrayList();

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int rs = 0;
        int re = m - 1;
        int cs = 0;
        int ce = n - 1;

        while (rs <= re && cs <= ce) {

            printMatrix(rs, re, cs, ce, matrix);
            rs++;
            cs++;
            re--;
            ce--;
        }

        return result;
    }

    void printMatrix(int rs, int re, int cs, int ce, int[][] matrix) {

        int i;

        // print top row
        for (i = cs; i <= ce; i++) {
            result.add(matrix[rs][i]);
        }

        // print vertical
        for (i = rs + 1; i <= re; i++)
            result.add(matrix[i][ce]);

        // print last row
        for (i = ce - 1; i >= cs && re != rs; i--)
            result.add(matrix[re][i]);

        // print last vertical
        for (i = re - 1; i >= rs + 1 && ce != cs; i--)
            result.add(matrix[i][cs]);
    }

}

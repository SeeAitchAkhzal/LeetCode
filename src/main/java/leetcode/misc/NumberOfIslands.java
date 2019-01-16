package leetcode.misc;

/**
 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Number of Islands.
 */

public class NumberOfIslands {

    int ic = 0;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    explore(i, j, m, n, grid);
                    ic++;
                }
            }
        }
        return ic;
    }

    void explore(int i, int j, int m, int n, char[][] grid) {

        if (grid[i][j] != '1')
            return;

        // previous
        if (i - 1 >= 0) {
            grid[i][j] = 'x';
            explore(i - 1, j, m, n, grid);
        }

        if (j - 1 >= 0) {
            grid[i][j] = 'x';
            explore(i, j - 1, m, n, grid);
        }

        if (i + 1 < m) {
            grid[i][j] = 'x';
            explore(i + 1, j, m, n, grid);
        }

        if (j + 1 < n) {
            grid[i][j] = 'x';
            explore(i, j + 1, m, n, grid);
        }
    }
}

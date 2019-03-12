package leetcode.misc;

/**
 * Runtime: 126 ms, faster than 24.69% of Java online submissions for Island Perimeter.
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int peri = 0;
        if (grid == null || grid.length == 0)
            return peri;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0)
                    continue;

                if (i - 1 < 0)
                    peri++;
                if (i + 1 >= m)
                    peri++;
                if (j - 1 < 0)
                    peri++;
                if (j + 1 >= n)
                    peri++;

                // check up
                if (i - 1 >= 0 && grid[i - 1][j] == 0)
                    peri++;

                // check down
                if (i + 1 < m && grid[i + 1][j] == 0)
                    peri++;

                // check left
                if (j - 1 >= 0 && grid[i][j - 1] == 0)
                    peri++;

                // check right
                if (j + 1 < n && grid[i][j + 1] == 0)
                    peri++;
            }
        }
        return peri;
    }

}

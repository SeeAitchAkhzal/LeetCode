package leetcode.misc;

/**
 * Runtime: 11 ms, faster than 56.73% of Java online submissions for Word Search.
 */
public class WordSearch {

    boolean[][] visited;
    char[][] board;
    String word;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (explore(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean explore(int i, int j, int curr) {

        if (visited[i][j])
            return false;

        char next = word.charAt(curr);

        if (next == board[i][j]) {

            visited[i][j] = true;

            if (curr + 1 == word.length())
                return true;

            if (i - 1 >= 0) {
                if (explore(i - 1, j, curr + 1)) {
                    return true;
                }
            }
            if (j - 1 >= 0) {
                if (explore(i, j - 1, curr + 1)) {
                    return true;
                }
            }
            if (i + 1 < m) {
                if (explore(i + 1, j, curr + 1)) {
                    return true;
                }
            }
            if (j + 1 < n) {
                if (explore(i, j + 1, curr + 1)) {
                    return true;
                }
            }

            visited[i][j] = false;
        }
        return false;
    }

}

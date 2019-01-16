package leetcode.misc;

/**
 * Runtime: 2 ms, faster than 52.96% of Java online submissions for Game of Life.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {

        int n = board.length;
        int m = board[0].length;

        calculateNextState(n,m,board);
        normalizeBoard(n,m,board);
    }

    void normalizeBoard(int n, int m, int[][] board){
        for(int i=0;i<n;i++) {
            for(int j=0; j< m;j++){
                board[i][j] = board[i][j] == 4 || board[i][j] == 5 ? 1 : 0;
            }
        }
    }


    /**
     *
     * alive --> dead : 3
     * alive --> alive: 4
     * dead --> alive : 5
     * dead --> dead : 6
     *
     */

    private int isAlive(int n, int m, int[][] board) {
        return (board[n][m] == 1 || board[n][m] == 3 || board[n][m] == 4) ?  1 : 0;
    }

    void calculateNextState(int n, int m,int[][] board){

        for(int i=0;i<n;i++) {
            for(int j=0; j< m;j++){

                int aliveCount = 0;
                // 1st neighbour
                if(i-1>=0 && j-1>=0) {
                    aliveCount +=  isAlive(i-1,j-1,board);
                }

                // 2nd neighbour
                if(i-1>=0) {
                    aliveCount +=  isAlive(i-1,j,board);
                }

                // 3rd neighbour
                if(i-1>=0 && j+1 <m) {
                    aliveCount +=  isAlive(i-1,j+1,board);
                }

                // 4th neighbour
                if(j-1 >=0) {
                    aliveCount +=  isAlive(i,j-1,board);
                }

                // 5th neighbour
                if(j+1 <m) {
                    aliveCount +=  isAlive(i,j+1,board);
                }

                // 6th neighbour
                if(i+1 <n && j-1 >=0) {
                    aliveCount +=  isAlive(i+1,j-1,board);
                }

                // 7th neighbour
                if(i+1<n) {
                    aliveCount +=  isAlive(i+1,j,board);
                }

                // 8th neighbour
                if(i+1<n && j+1 <m) {
                    aliveCount +=  isAlive(i+1,j+1,board);
                }

                boolean currentlyAlive = board[i][j] == 1;

                if(currentlyAlive){

                    if(aliveCount < 2){
                        board[i][j] = 3;
                    } else if(aliveCount == 2 || aliveCount == 3){
                        board[i][j] = 4;
                    } else if(aliveCount > 3){
                        board[i][j] = 3;
                    }

                }else{
                    board[i][j] = aliveCount == 3 ? 5 : 0;
                }

            }
        }
    }
}

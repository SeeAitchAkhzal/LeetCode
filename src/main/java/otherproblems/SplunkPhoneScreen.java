package otherproblems;

import java.util.LinkedList;
import java.util.Queue;

class Pair {

    public Pair(int i, int j, String path) {
        this.i = i;
        this.j = j;
        this.pathSoFar = path;
    }

    int i;
    int j;
    String pathSoFar;
}

public class SplunkPhoneScreen {

    int[][] BAD;

    public SplunkPhoneScreen(int[][] BAD) {
        this.BAD = BAD;
    }

    void printResult(String path) {
        String[] tokens = path.split("-");
        System.out.println("Min steps : " + (tokens.length - 1));
        System.out.println();

        for (String str : tokens) {
            if (!"".equals(str)) {
                System.out.print(str + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    void findShortestPath() throws Exception {

        if (BAD == null || BAD.length == 0 || BAD[0].length == 0)
            throw new Exception("incorrect BAD matrix");

        int m = BAD.length;
        int n = BAD[0].length;

        boolean[][] visited = new boolean[m][n];

        Pair root = new Pair(0, 0, "");
        Queue<Pair> q = new LinkedList();

        q.add(root);

        boolean found = false;

        // There can never be a path if the
        // right bottom corner itself is a
        // bad neighborhood.
        if (BAD[m - 1][n - 1] == 1)
            q.poll();

        while (!q.isEmpty()) {

            Pair p = q.poll();

            if (p.i == m - 1 && p.j == n - 1) {
                found = true;
                printResult(p.pathSoFar);
                break;
            }

            String pathSoFar = p.pathSoFar;

            // check if we can go up
            int a = p.i - 1;
            int b = p.j;
            if (a >= 0 && !visited[a][b] && BAD[a][b] == 0) {
                visited[a][b] = true;
                q.add(new Pair(a, b, pathSoFar + "-u"));
            }

            // check if we can go down
            a = p.i + 1;
            b = p.j;
            if (a < m && !visited[a][b] && BAD[a][b] == 0) {
                visited[a][b] = true;
                q.add(new Pair(a, b, pathSoFar + "-d"));
            }

            // check if we can go left
            a = p.i;
            b = p.j - 1;
            if (b >= 0 && !visited[a][b] && BAD[a][b] == 0) {
                visited[a][b] = true;
                q.add(new Pair(a, b, pathSoFar + "-l"));
            }

            // check if we can right
            a = p.i;
            b = p.j + 1;
            if (b < n && !visited[a][b] && BAD[a][b] == 0) {
                visited[a][b] = true;
                q.add(new Pair(a, b, pathSoFar + "-r"));
            }

        }

        if (!found) {
            System.out.println();
            System.out.println("No path exists.");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        int[][] BAD = new int[][] {
                { 0, 1, 0, 0 },
                { 0, 1, 0, 1 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };

        SplunkPhoneScreen program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        BAD = new int[][] {
                { 0, 0, 1, 0, 0, 1 },
                { 0, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 0 },
                { 0, 0, 0, 1, 0, 0 },
                { 1, 0, 1, 0, 0, 0 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        BAD = new int[][] {
                { 0, 1, 0, 0 },
                { 0, 1, 0, 1 },
                { 0, 0, 0, 1 },
                { 0, 0, 1, 0 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        BAD = new int[][] { { 0, 1, 0, 0 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        BAD = new int[][] { { 0, 0 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        // The right bottom corner is itself a bad neighbourhood
        BAD = new int[][] { { 0, 1 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        BAD = new int[][] { { 0 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        BAD = new int[][] { { 1 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        BAD = new int[][] {
                { 0 },
                { 0 },
                { 0 },
                { 0 },
                { 0 },
                { 0 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();

        BAD = new int[][] {
                { 0 },
                { 0 },
                { 0 },
                { 0 },
                { 0 },
                { 1 } };
        program = new SplunkPhoneScreen(BAD);
        program.findShortestPath();
    }

}

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] m={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        int n=4;
        findPath(m,n);
    }

    public static void findPath(int[][] m, int n) {
        // Your code here
        boolean[][] b=new boolean[n][n];
        findPathHelper(m,n,b,"",0,0);
    }

    private static void findPathHelper(int[][] maze, int n, boolean[][] b, String proc, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(proc);
            return;
        }
        if (maze[row][col] == 0 || b[row][col] == true)
            return;

        b[row][col] = true;
        if (row < n - 1 && col < maze[0].length)
            findPathHelper(maze, n, b, proc + "D", row + 1, col);

        if (col < n - 1)
            findPathHelper(maze, n, b, proc + "R", row, col + 1);

        if (row > 0)
            findPathHelper(maze, n, b, proc + "U", row - 1, col);

        if (col > 0)
            findPathHelper(maze, n, b, proc + "L", row, col - 1);
        b[row][col] = false;


    }
}

import java.util.Arrays;

public class MazePrintDRUL_paths {

    public static void main(String[] args) {
        boolean[][] maze = {{true, true, true},
                {true, true, true},
                {true, true, true}};
      //  printAllPaths("", maze, 0, 0);
        int[][] path=new int[maze.length][maze[0].length];
        allPathPrint("",maze,0,0,path,0);
    }

    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for(int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            allPathPrint(p + 'D', maze, r+1, c, path, step+1);
        }

        if (c < maze[0].length - 1) {
            allPathPrint(p + 'R', maze, r, c+1, path, step+1);
        }

        if (r > 0) {
            allPathPrint(p + 'U', maze, r-1, c, path, step+1);
        }

        if (c > 0) {
            allPathPrint(p + 'L', maze, r, c-1, path, step+1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
        path[r][c] = 0;
    }



    public static void printAllPaths(String proc, boolean[][] maze, int row, int column) {
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.print(proc + ", ");
            return;
        }
        if (!maze[row][column])
            return;

        maze[row][column] = false;

        if (row < maze.length - 1)
            printAllPaths(proc + "D", maze, row + 1, column);

        if (column < maze[0].length - 1)
            printAllPaths(proc + "R", maze, row, column + 1);
        if (row > 0)
            printAllPaths(proc + "U", maze, row - 1, column);
        if (column > 0)
            printAllPaths(proc + "L", maze, row, column - 1);

        if (!maze[row][column])
            maze[row][column] = true;

    }
}

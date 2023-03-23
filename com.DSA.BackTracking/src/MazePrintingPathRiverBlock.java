public class MazePrintingPathRiverBlock {
    public static void main(String[] args) {
        boolean[][] board = {{true, true, true},
                            {true, false, true},
                             {true, true, true}};
        MazePrintingRiverBlock("",board, 0, 0);
    }

    public static void MazePrintingRiverBlock(String proc, boolean[][] maze, int row,int column) {
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.print(proc+",");
            return;
        }
        if (!maze[row][column])
            return;

        if (row < maze.length - 1)
            MazePrintingRiverBlock(proc + "D", maze, row + 1, column);
        if (column < maze.length - 1)
            MazePrintingRiverBlock(proc + "R", maze, row, column + 1);
    }
    public static void MazePrintingRiverBlock(String proc,int row,int column) {
        if (row == 2 && column == 2) {
            System.out.print(proc + ",");
            return;
        }
        if (row == 1 && column == 1)
            return;

        if (row < 2)
            MazePrintingRiverBlock(proc + "D", row + 1, column);

        if (column < 2)
            MazePrintingRiverBlock(proc + "R", row, column + 1);


    }

}

public class Maze_countingPaths {

    public static void main(String[] args) {
        int row = 3, column = 3;
        System.out.println(MazeOptimize(row, column));
    }

    public static int MazeOptimize(int row, int column) {
        if (row == 1 || column == 1)
            return 1;
        return MazeOptimize(row - 1, column) + MazeOptimize(row, column - 1);
    }

    public static int Maze(int row, int column) {
        if (row == 1 || column == 1)
            return 1;

        int count = 0;
        count = count + Maze(row - 1, column);
        count = count + Maze(row, column - 1);

        return count;
    }


}

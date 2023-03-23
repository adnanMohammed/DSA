public class MazePathIncDiagnal {
    public static void main(String[] args) {
        MazePathDiagonalPrint("", 3, 3);
        System.out.println();
    }

    public static int MazePathDiagonalCount(int row, int column) {
        if (row == 1 || column == 1)
            return 1;

        int count = 0;
        count = count + MazePathDiagonalCount(row - 1, column);
        count = count + MazePathDiagonalCount(row - 1, column - 1);
        count = count + MazePathDiagonalCount(row, column - 1);

        return count;

    }

    public static void MazePathDiagonalPrint(String proc, int row, int column) {
        if (row == 1 && column == 1) {
            System.out.print(proc + ",");
            return;
        }
        if (row > 1)
            MazePathDiagonalPrint(proc + "D", row - 1, column);
        if (row > 1 && column > 1)
            MazePathDiagonalPrint(proc + "Di", row - 1, column - 1);

        if (column > 1)
            MazePathDiagonalPrint(proc + "R", row, column - 1);


    }
}

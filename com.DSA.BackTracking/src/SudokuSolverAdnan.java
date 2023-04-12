import java.util.Arrays;

public class SudokuSolverAdnan {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(sudokuSolve(board)){
            for (int[] b:board) {
                System.out.print(Arrays.toString(b));
                System.out.println();
            }

        }
        else System.out.println("cant solve");
    }

    public static boolean sudokuSolve(int[][] board) {
        int row=-1,col=-1;
        boolean isOccupied=true;

        for (int row1 = 0; row1 < board.length; row1++) {
            for (int col1 = 0; col1 < board.length; col1++) {
                if(board[row1][col1]==0){
                    row=row1;col=col1;
                    isOccupied=false;
                    break;
                }
            }
            if(!isOccupied)
                break;
        }

        if(isOccupied)
            return true;

        for (int num = 1; num <= board.length ; num++) {
            if(isSafe(board,row,col,num)){
                board[row][col]=num;
                if(sudokuSolve(board)){
                    return true;
                }
                else{
                    board[row][col]=0;
                }
            }
        }

        return false;
    }


    public static boolean isSafe(int[][] board, int row, int col, int num) {

        //row check
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num)
                return false;
        }
        //col check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num)
                return false;
        }
        //3*3 matrix check
        int rowStart = row - (row % 3);
        int colStart = col - (col % 3);
        for (int i = rowStart; i <= rowStart + 2; i++) {
            for (int j = colStart; j <= colStart + 2; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}

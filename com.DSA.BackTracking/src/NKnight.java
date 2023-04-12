public class NKnight {
    public static void main(String[] args) {
        boolean[][] board=new boolean[4][4];
        int row=0;int col=0; int knight=4;
        Knight(board,row,col,knight);
    }

    public static void Knight(boolean[][] board, int row, int col, int knight) {
        if (knight == 0) {
            display(board);
            return;
        }

        if (row>= board.length-1 && col >= board.length)
            return;

        if (row < board.length && col >= board.length) {
            Knight(board, row + 1, 0, knight);
            return;
        }

        if (isSafe(board, row, col, knight)) {
            board[row][col] = true;
            Knight(board, row, col + 1, knight - 1);
            board[row][col] = false;
        }
        Knight(board, row, col + 1, knight);

    }

    private static boolean isSafe(boolean[][] board, int row, int col, int knight) {
        if (isValid(row - 2, col - 1, board)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(row - 2, col + 1, board)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(row - 1, col - 2, board)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        if (isValid(row - 1, col + 2, board)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValid(int row, int col,boolean[][] board) {
        if((row>=0 && row< board.length) && (col>=0 && col< board.length))
            return true;
        else
            return false;

    }

    public static void display(boolean[][] board) {
        for (boolean[] b : board) {
            for (boolean b1 : b) {
                if (b1)
                    System.out.print("K ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

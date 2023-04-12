public class NQueens {

    public static void main(String[] args) {
        int N = 4;
        boolean[][] board = new boolean[N][N];
        int row = 0;
        System.out.println(NQueen(N, board, row));
    }

    public static int NQueen(int N, boolean[][] board, int row) {
        if (row == N) {
            display(board);
            return 1;
        }

        int count = 0;
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count = count + NQueen(N, board, row + 1);
                board[row][col] = false;
            }


        }

        return count;
    }

    public static void display(boolean[][] board) {
        for (boolean[] b : board) {
            for (boolean b1 : b) {
                if (b1)
                    System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false;
        }

        int min = Math.min(row, col);
        for (int i = 1; i <= min; i++) {
            if (board[row - 1][col - 1])
                return false;
        }

        int range = Math.min(row, board.length - col - 1);
        for (int i = 0; i < range; i++) {
            if (board[row - 1][col + 1])
                return false;
        }

        return true;
    }

}

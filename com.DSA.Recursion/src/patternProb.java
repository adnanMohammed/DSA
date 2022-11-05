public class patternProb {
    public static void main(String[] args) {
        int n = 4;
        //patternNormalTriangleRecur(n, 1,1,1);
        patternTriangleRecur(n,0);
    }

    private static void patternTriangleRecursion(int n) {
        if (n == 0) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println();
        patternTriangleRecursion(n - 1);
    }

    private static void patternTriangleRecur(int row, int column) {
        if (row == 0)
            return;
        if (column < row) {
            System.out.print("* ");
            patternTriangleRecur(row, column += 1);
        } else {
            System.out.println();
            patternTriangleRecur(row - 1, 0);
        }

    }

    private static void patternNormalTriangleRecur(int row, int column, int space,int incColumn) {
        if (row == 0)
            return;
        else if (space < row) {
            System.out.print(" ");
            patternNormalTriangleRecur(row, column, space + 1,incColumn);
        } else if (column > 0) {
            System.out.print("* ");
            patternNormalTriangleRecur(row, column - 1, space,incColumn);
        } else if (space == row) {
            System.out.println();
            incColumn+=2;
            patternNormalTriangleRecur(row - 1, incColumn, 1,incColumn);
        }

    }

}

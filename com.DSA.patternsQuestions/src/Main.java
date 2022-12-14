public class Main {
    public static void main(String[] args) {
        pattern5_optimized(5);
    }


    public static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= n; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = row; column <= n; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print(column+" ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = n-1; row >=1; row--) {
            for (int column = 1; column <= row; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern5_optimized(int n) {
        for (int row = 1; row <= (2 * n - 1); row++) {
            int printColumn = (row <= n) ? row : 2 * n - row;
            for (int column = 1; column <= printColumn; column++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
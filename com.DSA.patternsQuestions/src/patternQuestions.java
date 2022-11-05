public class patternQuestions {
    public static void main(String[] args) {
        int n = 5;
        //trianglePattern(n);
        //trianglePattern1(n);
        //trianglePattern3(n);
        //trianglePattern5(n);
        //trianglePattern4(n);
        patternQ30(n);
    }

    private static void trianglePattern(int n) {
        int print=1;
        for (int row = 1; row <= n ; row++) {
            for (int colSpace = 1; colSpace <=n-row ; colSpace++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= print ; col++) {
                System.out.print("*");
            }
            print+=2;
            System.out.println();

        }
    }

    private static void trianglePattern1(int n) {
        int print=(2*n)-1;
        for (int row = 1; row <= n ; row++) {
            for (int colSpace = 1; colSpace <row ; colSpace++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= print ; col++) {
                System.out.print("*");
            }
            print-=2;
            System.out.println();

        }
    }


    private static void trianglePattern3(int n) {
        int print = 1;
        int p = 0;
        for (int row = 1; row <= (2 * n - 1); row++) {
            int space = (row > n) ? row - n : n - row;
            for (int colSpace = 1; colSpace <= space; colSpace++) {
                System.out.print(" ");
            }
            p = (row > n) ? (p+=4) : p;
            int colP = row > n ? (print - p) : print;

            for (int colPrint = 1; colPrint <= colP; colPrint++) {
                System.out.print("*");
            }
            System.out.println();
            print += 2;


        }
    }


    private static void trianglePattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int colSpace = 1; colSpace <= n - row; colSpace++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }

            System.out.println();

        }
    }

    private static void trianglePattern5(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space < row; space++) {
                System.out.print(" ");
            }
            for (int column = row; column <= n; column++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }

    private static void patternQ30(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print("  ");
            }

            for (int k = row; k >= 1; k--) {
                System.out.print(k+" ");
            }
            for (int l = 2; l <= row; l++) {
                System.out.print(l+" ");
            }
            System.out.println();
        }

    }
}

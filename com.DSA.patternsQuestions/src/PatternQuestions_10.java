public class PatternQuestions_10 {
    public static void main(String[] args) {
        int n=4;
        /* 1
         * * *
         * * *
         * * *
         */
        PatternQuestions_10.pattern1(n);
        /*2
         *
         * *
         * * *
         */
        PatternQuestions_10.pattern2(n);

        /* 3
        1
        1 2
        1 2 3
         */
        PatternQuestions_10.pattern3(n);
        /*
        1
        2 2
        3 3 3
         */
        PatternQuestions_10.pattern4(n);
        /*
         * * *
         * *
         *
         */
        PatternQuestions_10.pattern5(n);

        /* 6
        1 2 3
        1 2
        1
         */
        PatternQuestions_10.pattern6(n);
        /*7
         *
        ***
       *****
      *******
     *********
         */
        PatternQuestions_10.pattern7(5);
        /*8
         *****
          ***
           *
         */
        PatternQuestions_10.pattern8(n);
        System.out.println();
        /*9
         *
        ***
       *****
       *****
        ***
         *
         */
        PatternQuestions_10.pattern9(n);

        /*
         *
         **
         ***
         **
         *
         */
        PatternQuestions_10.pattern10(n);
    }

    private static void pattern10(int n) {
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n-1; i >=1 ; i--) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void pattern9(int n) {
        PatternQuestions_10.pattern7(n);
        PatternQuestions_10.pattern8(n);
    }
    private static void pattern8(int n) {

        int m=0;
        for (int i = n; i >=1 ; i--) {
            int k=(2*i)-1;
            for (int j = 0; j <m ; j++) {
                System.out.print(" ");
            }
            m+=1;
            for (int j = 1; j <=k ; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    private static void pattern7(int n) {
        int n1 = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n1; j++) {
                System.out.print("*");
            }
            n1 += 2;
            System.out.println();

        }
    }

    private static void pattern6(int n) {
        for (int i = n; i >=1 ; i--) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void pattern5(int n) {
        for (int i = n; i>=1 ; i--) {
            for (int j=i;j>=1;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern1(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

    }
}

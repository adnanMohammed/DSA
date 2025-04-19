public class PatternQuestions_11to20 {
    public static void main(String[] args) {
        /*11
        1
        01
        101
         */
        PatternQuestions_11to20.pattern11(5);
        /*12
        1    1
        12  21
        123321
         */
        PatternQuestions_11to20.pattern12(3);
        /*
        1
        2 3
        4 5 6
         */
        PatternQuestions_11to20.pattern13(3);
        /*
        A
        A B
        A B C
         */
        PatternQuestions_11to20.pattern14(3);
        /*15
         A
        ABA
       ABCBA
         */
        PatternQuestions_11to20.pattern15(5);
        /* 16
         ******
         **  **
         *    *
         *    *
         **  **
         ******
         */
        PatternQuestions_11to20.pattern16(8);
    }

    private static void pattern16(int n) {
        int k=n*2;int m=0;int row=1;int k1=0;
        for ( row = 1; row < k ; row++) {
            k1=(row<=n)?n-(row-1):k1+1;
            for (int i = 0; i < k1; i++) {
                System.out.print("*");
            }
            for (int i = 0; i <m ; i++) {
                System.out.print(" ");
            }
            m=(row>=n)?(m-2):(m+2);
            for (int i = 0; i < k1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern15(int n) {
        for (int i = 1; i <= n ; i++) {
            for (int j = i; j <n ; j++) {
                System.out.print(" ");
            }
            int val=65;
            for (int j = 1; j <=i ; j++) {
                System.out.print((char)val++);
            }
            val-=2;
            for (int k = 1; k <i ; k++) {
                System.out.print((char) val--);
            }
            System.out.println();
        }
    }

    public static void pattern14(int n) {
        for (int i = 1; i <=n ; i++) {
            int c=65;
            for (int j = 1; j <=i ; j++) {
                System.out.print((char)c+" ");
                c+=1;
            }
            System.out.println();
        }
    }

    public static void pattern13(int n) {
        int count=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(count+" ");
            count+=1;
            }
            System.out.println();
        }
    }
    public static void pattern12(int n) {
        for (int i = 1; i <= n; i++) {
            int res = (int) Math.pow(2, n - i);
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            if(res!=1) {
                for (int j = 1; j <= res; j++) {
                    System.out.print(" ");
                }
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();

        }
    }


    public static void pattern11(int n){
        int print=1;
        for (int i = 1; i <=n ; i++) {
            int printIn=print;
            for (int j = 1; j <=i ; j++) {
                System.out.print(printIn+" ");
                printIn=printIn==1?0:1;
            }
            print=print==1?0:1;
            System.out.println();
        }

    }
}

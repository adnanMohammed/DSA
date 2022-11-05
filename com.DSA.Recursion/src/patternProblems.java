public class patternProblems {
    public static void main(String[] args) {
        pattern1(0,3);
    }

    public static void pattern1() {
        for (int i = 0; i <= 3 ; i++) {
            for (int j = 4-i; j >=1 ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //using recursion
    public static void pattern1(int row,int column) {
       if(row==column+1)
           return;
       else{
           for (int i = row; i <=column; i++) {
               System.out.print("* ");
           }
           System.out.println();
           pattern1(row+1,column);
       }
    }
}

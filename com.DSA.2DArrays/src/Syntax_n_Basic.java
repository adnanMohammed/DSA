import java.util.Arrays;
import java.util.Scanner;

public class Syntax_n_Basic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr=new int[3][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=in.nextInt();
            }
        }

        for (int[] a1:arr) {
            System.out.println(Arrays.toString(a1));

        }


        int[][] ar = {{1,2}, {3,4,5,6,7}, {8,9,10}, {11}};

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
               System.out.print(ar[i][j]+" ");
               // System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println();
        }
    }
}
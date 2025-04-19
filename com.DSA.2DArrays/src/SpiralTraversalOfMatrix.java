import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {
   //     int[][] matrix = {{1, 2, 3, 4, 5, 6}, {20, 21, 22, 23, 24, 7}, {19, 32, 33, 34, 25, 8}, {18, 31, 36, 35, 26, 9}, {17, 30, 29, 28, 27, 10}, {16, 15, 14, 13, 12, 11}};
     //int[][] matrix={{1,3,7,8,18},{10,12,15,9,19},{19,20,21,10,100},{14,13,12,11,110},{2,4,6,8,10}};
    //   int[][] matrix={{ 1, 3, 7 ,9},{10, 12 ,15 ,17},{19, 20, 21, 50}};

        int[][] matrix= {{ 1, 3 ,7 ,9} ,{10 ,12, 15, 17} ,{19 ,20 ,21, 50}};

        spiralMatrix(matrix);
    }


    public List<Integer> spiralOrder(int[][] MATRIX) {
        List<Integer> arr=new ArrayList<>();
        int left = 0, right = MATRIX[0].length - 1, top = 0, bottom = MATRIX.length - 1;
        int count = 0;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                arr.add(MATRIX[top][j]);
                count++;
            }
            top++;
            for (int j = top ; j <= bottom; j++) {
                arr.add(MATRIX[j][right]);
                count++;
            }
            right--;
            if(top<=bottom) {
                for (int j = right; j >= left; j--) {
                    arr.add(MATRIX[bottom][j]);
                    count++;
                }
                bottom--;
            }
            if(left<=right) {
                for (int j = bottom; j >= top; j--) {
                    arr.add(MATRIX[j][left]);
                    count++;
                }
                left++;
            }

        }
        return arr;


    }


    public static int[] spiralMatrix(int[][] MATRIX) {
        // Write your code here.
        int[] arr = new int[MATRIX.length * MATRIX[0].length];
        int left = 0, right = MATRIX[0].length - 1, top = 0, bottom = MATRIX.length - 1;
        int count = 0;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                arr[count] = MATRIX[top][j];
                count++;
            }
            top++;
            for (int j = top ; j <= bottom; j++) {
                arr[count] = MATRIX[j][right];
                count++;
            }
            right--;
            if(top<=bottom) {
                for (int j = right; j >= left; j--) {
                    arr[count] = MATRIX[bottom][j];
                    count++;
                }
                bottom--;
            }
            if(left<=right) {
                for (int j = bottom; j >= top; j--) {
                    arr[count] = MATRIX[j][left];
                    count++;
                }
                left++;
            }

        }
        return arr;
    }
}

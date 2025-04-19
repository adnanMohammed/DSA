import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotateTheMatrix {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix);
    }

    public static void rotateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }


    public static void rotate(int[][] matrix) {
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        for (int row = 0; row < matrix.length; row++) {
            List<Integer> l = new ArrayList();
            for (int col = 0; col < matrix[row].length; col++) {
                l.add(matrix[row][col]);
            }
            m.put(row, l);
        }

        int n = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            List<Integer> value = m.get(i);
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][n] = value.get(j);
            }
            n += 1;
        }
    }
}

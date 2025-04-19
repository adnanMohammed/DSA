import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        l1.add(1);
        l1.add(1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(0);
        l2.add(1);
        l2.add(1);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(1);
        l3.add(0);
        l3.add(1);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(0);
        l4.add(1);
        l4.add(1);
        l4.add(1);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(l1);
        matrix.add(l2);
        matrix.add(l3);
        matrix.add(l4);
        Integer row = matrix.size();
        Integer col = matrix.get(0).size();
       // setZeroes(matrix);
    }

    //optimal Solution with 0(1) Aux Space

    public static void setZeroes(int[][] matrix) {
        int col0 = 0;
        for (int row = matrix.length - 1; row > 0; row--) {
            for (int col = matrix[row].length; col > 0; col--) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = -1;
                    matrix[row][col] = -1;
                }
            }
        }

        for (int i = matrix[0].length - 1; i > 0; i--) {
            if (matrix[0][i] == 0) {
                matrix[0][i] = -1;

            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                matrix[i][0] = -1;
                col0 = -1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == -1) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == -1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }

            }
        }

        if(col0==-1){
            for (int i = 0; i < matrix.length; i++) {
                matrix[0][i]=0;
            }
        }

    }



    //better Solution
    public static ArrayList<ArrayList<Integer>> zeroMatrixBruteForce(ArrayList<ArrayList<Integer>> matrix, Integer row, Integer col) {
        int[] rowArr = new int[row];
        int[] colArr = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 0) {
                    rowArr[i] = -1;
                    colArr[j] = -1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            if (rowArr[i] == -1) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        for (int i = 0; i < colArr.length; i++) {
            if (colArr[i] == -1) {
                for (int j = 0; j < row; j++) {
                    matrix.get(j).set(i, 0);
                }

            }
        }
        return matrix;
    }

}

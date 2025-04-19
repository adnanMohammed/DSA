import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int[][] resArray = pascalTriangle(5);
        List<List<Integer>> resList = generate(5);
        System.out.println( findElementGivenRowNCol(resList, 2, 2));
        System.out.println( findElementGivenRowNCol(resArray, 2, 2));
        printNRow(resList,resList.size()-1);
    }

    public static int findElementGivenRowNCol(List<List<Integer>> resList, int row, int col) {
        return resList.get(row-1).get(col-1);
    }

    public static void printNRow(List<List<Integer>> resList, int row) {
        resList.get(row).stream().forEach(System.out::print);
    }

    public static int findElementGivenRowNCol(int[][] resArr, int row, int col) {
        return resArr[row-1][col-1];
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    l.add(1);
                else {
                    List<Integer> temp = list.get(i - 2);
                    for (int k = 1; k < temp.size(); k++)
                        l.add(temp.get(k - 1) + temp.get(k));
                    j = i - 1;
                }

            }
            list.add(l);
        }
        return list;
    }

    public static int[][] pascalTriangle(int N) {
        // Write your code here.
        List<List<Integer>> list = new ArrayList<>();
        int[][] arr = new int[N][];
        for (int i = 1; i <= N; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    l.add(1);
                else {
                    List<Integer> temp = list.get(i - 2);
                    for (int k = 1; k < temp.size(); k++)
                        l.add(temp.get(k - 1) + temp.get(k));
                    j = i - 1;
                }
            }
            list.add(l);
            arr[i - 1] = l.stream().mapToInt(i1 -> i1).toArray();
        }

        return arr;
    }
}

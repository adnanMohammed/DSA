import java.util.ArrayList;
import java.util.Arrays;

public class UnionNIntersectionOfArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(4);
        arr2.add(6);
        arr2.add(8);
        UnionandIntersectionOfArrayCN(arr1, arr2, arr1.size(), arr2.size());
    }

    //My Solution
    private static ArrayList<Integer> UnionandIntersectionOfArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr2.size(); j++) {
                if (arr1.get(i).equals(arr2.get(j))) {
                    arr.add(arr1.get(i));
                    arr2.set(j, 0);
                }
            }
        }

        for (int i = 0; i < arr2.size(); i++) {
            if (!arr2.get(i).equals(0)) {
                arr1.add(arr2.get(i));
            }
        }
        int arrSize = arr.size();
        int arr1Size = arr1.size();
        arr = new ArrayList<>();
        arr.add(arrSize);
        arr.add(arr1Size);

        return arr;
    }

    // Coding Ninja solution
    private static ArrayList<Integer> UnionandIntersectionOfArrayCN(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m) {
        int intersectionSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((int)arr1.get(i) == (int)arr2.get(j))
                    intersectionSize++;
            }
        }

        int unionSize = n + m - intersectionSize;
        ArrayList < Integer > res = new ArrayList < Integer > ();
        res.add(intersectionSize);
        res.add(unionSize);

        for (int i:
             res) {
            System.out.print(i+" ");
        }

        return res;
    }
}

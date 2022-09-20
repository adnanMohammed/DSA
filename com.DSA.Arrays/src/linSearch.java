import java.util.ArrayList;

public class linSearch {
    public static void main(String[] args) {
        int[] arr = {9, 3, 2, 7, 5, 8, 1};
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(9);
        ar.add(3);
        ar.add(2);
        ar.add(7);
        ar.add(5);
        ar.add(8);
        ar.add(1);
        ar.add(6);
        linearSearch(ar, ar.size(), 3);
    }

    public static ArrayList<Integer> linearSearch(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    arr.set(i, arr.get(i) + arr.get(j));
                    arr.set(j, arr.get(i) - arr.get(j));
                    arr.set(i, arr.get(i) - arr.get(j));
                }

            }
        }

        int kMin = arr.get(k - 1);
        int kMax = arr.get(arr.size() - k);
        ArrayList<Integer> minMax = new ArrayList<>();
        minMax.add(kMin);
        minMax.add(kMax);
        System.out.println(minMax.toString());
        return minMax;
    }
}

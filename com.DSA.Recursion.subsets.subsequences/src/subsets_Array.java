import java.util.ArrayList;

public class subsets_Array {

    public static void main(String[] args) {
        subsetRemoveDuplicates(new int[]{1,2,2});
    }

    public static ArrayList<ArrayList<Integer>> subsetRemoveDuplicates(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> inner = new ArrayList<Integer>(outer.get(i));
                inner.add(num);
                if (!outer.contains(inner))
                    outer.add(inner);
            }
        }
        return outer;
    }
    public static ArrayList<ArrayList<Integer>> subset(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> inner = new ArrayList<Integer>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}

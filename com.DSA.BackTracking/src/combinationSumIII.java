import java.util.ArrayList;
import java.util.List;

public class combinationSumIII {
    public static void main(String[] args) {
        int k = 3, n = 9;
        System.out.println(combinationSum3(k, n));

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        combinationSum3Helper(1, 0, n, li, l, k);
        return li;
    }

    private static void combinationSum3Helper(int index, int sum, int n, List<List<Integer>> li, List<Integer> l, int k) {
        if (sum == n && k == 0) {
            li.add(new ArrayList<>(l));
            return;
        }
        if (sum > n || k<0)
            return;

        for (int i = index; i <= 9; i++) {
            l.add(i);
            combinationSum3Helper(i + 1, sum + i, n, li, l, k - 1);
            l.remove(l.size() - 1);
        }
    }
}

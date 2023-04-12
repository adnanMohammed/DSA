import java.util.ArrayList;
import java.util.List;

public class combinations {

    public static void main(String[] args) {
      int n = 4, k = 2;
        System.out.println(combine(n,k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> li=new ArrayList<>();
          return  combinationHelper(1,n,k,new ArrayList<Integer>(),li);
    }

    private static List<List<Integer>> combinationHelper(int index, int n, int k, ArrayList<Integer> l, List<List<Integer>> li) {
        if (k == 0) {
            li.add(new ArrayList<>(l));
            return li;
        }
        for (int i = index; i <= n; i++) {
            l.add(i);
            combinationHelper(i + 1, n, k - 1, l, li);
            l.remove(l.size() - 1);
        }
        return li;
    }
}

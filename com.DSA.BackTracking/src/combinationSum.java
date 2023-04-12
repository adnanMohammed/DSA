import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) {
        int[] candidate = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> l1 = combinationSum(candidate, target);
        for (List<Integer> l2 : l1) {
            for (int i1 : l2) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> l = new ArrayList<>();
        boolean b = false;
        int index = 0;
        List<List<Integer>> li = new ArrayList<>();

        return combination(index, target, l, candidates, li);

    }

    private static List<List<Integer>> combination(int index, int target, List l, int[] candidates, List<List<Integer>> li) {
        //Answer and Base condition
        if (target == 0) {
            li.add(new ArrayList<Integer>(l));
            return li;
        }
        //Base condition
        if (index == candidates.length)
            return li;

        if (target >= candidates[index]) {
            l.add(candidates[index]);
            combination(index, target - candidates[index], l, candidates, li);
            //Back Track
            l.remove((l.size() - 1));

        }
        return combination(index + 1, target, l, candidates, li);

    }

}

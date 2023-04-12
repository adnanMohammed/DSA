import java.util.*;

public class combinationSumII {
    public static void main(String[] args) {
        int[] candidate = {1, 1, 1, 2, 2};
        int target = 4;
        List<List<Integer>> l1 = combinationSum2(candidate, target);
        System.out.println(l1.toString());

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> l = new ArrayList<>();

        int index = 0;
        List<List<Integer>> li = new ArrayList<>();
        Arrays.sort(candidates);
        return combination_SUM_II_optimize(index, target, l, candidates, li);

        /*List<List<Integer>> res1=new ArrayList<>();
        for (List<Integer> r1:res) {
            res1.add(r1);
        }
            return res1;*/
    }

    //optimize solution
    private static List<List<Integer>> combination_SUM_II_optimize(int index, int target, List l, int[] candidates, List<List<Integer>> li) {
        //Answer and Base condition
        if (target == 0) {
            li.add(new ArrayList<Integer>(l));
            return li;
        }
        //Base condition
        if (index == candidates.length)
            return li;

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (target < candidates[i])
                break;
            l.add(candidates[i]);
            combination_SUM_II_optimize(i + 1, target - candidates[i], l, candidates, li);
            l.remove(l.size() - 1);

        }

        return li;
    }


    //brute force solution same as combination SUM I just a slight change
    private static Set<List<Integer>> combination_SUM_II(int index, int target, List l, int[] candidates, Set<List<Integer>> li) {
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
            combination_SUM_II(index + 1, target - candidates[index], l, candidates, li);
            //Back Track
            l.remove((l.size() - 1));

        }
        return combination_SUM_II(index + 1, target, l, candidates, li);

    }

}

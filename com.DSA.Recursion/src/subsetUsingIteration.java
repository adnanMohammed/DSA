import java.util.ArrayList;
import java.util.List;


public class subsetUsingIteration {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = subsetIteration(arr);
        for (List<Integer> a : ans) {
            for (int i : a) {
                System.out.print(i + " ,");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> subsetIteration(int[] arr) {
        List<List<Integer>> outerList = new ArrayList();//outerList
        outerList.add(new ArrayList<Integer>());
        for (int num : arr) {
            int size = outerList.size();
            for (int i = 0; i < size; i++) {
                List<Integer> internalList = new ArrayList<>(outerList.get(i));
                internalList.add(num);
                if (!outerList.contains(internalList)) {
                    outerList.add(internalList);
                }
            }
        }
        return outerList;
    }


}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NegNumbersAtBegining {
    public static void main(String[] args) {
        ArrayList<Integer> inp = new ArrayList<>();
        inp.add(1);
        inp.add(4);
        inp.add(-2);
        inp.add(3);
        inp.add(-6);
        inp.add(8);
        inp.add(-6);
        ArrayList<Integer> arr = negNumbersAtBegining_CN(inp);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //my Solution
    private static ArrayList<Integer> negNumbersAtBegining(ArrayList<Integer> nums) {
        int[] arr = new int[nums.size()];
        int size = nums.size() - 1;
        int add = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < 0) {
                arr[add] = nums.get(i);
                add = add + 1;
            }
            if (nums.get(i) >= 0) {
                arr[size] = nums.get(i);
                size = size - 1;
            }
        }
        ArrayList<Integer> inp = new ArrayList<>();
        for (int i1 : arr) {
            inp.add(i1);

        }
        return inp;
    }

    //Coding ninjas solution
    private static ArrayList<Integer> negNumbersAtBegining_CN(ArrayList<Integer> nums) {
        Collections.sort(nums);

        return nums;
    }


}

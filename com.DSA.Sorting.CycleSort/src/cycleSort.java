import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cycleSort {
    public static void main(String[] args) {
        int[] arr = {1,1};

        for (int i:findDisappearedNumbers(arr)) {
          System.out.print(i+" ");
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if ((nums[i] != i + 1) && (nums[i] != nums[nums[i] - 1])) {
                int correct = nums[i] - 1;
                nums[i] = nums[i] + nums[correct];
                nums[correct] = nums[i] - nums[correct];
                nums[i] = nums[i] - nums[correct];

            } else i++;
        }
        List<Integer> l = new ArrayList<Integer>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) l.add(j + 1);
        }
        return l;
    }
}
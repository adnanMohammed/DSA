import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllDuplicateNumbersInArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        for(int i:findDuplicates(nums)){
            System.out.print(i+" ");
        }
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[correct] != nums[i]) {
                //swap
                nums[correct] = nums[correct] + nums[i];
                nums[i] = nums[correct] - nums[i];
                nums[correct] = nums[correct] - nums[i];

            } else {
                i++;
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                res.add(nums[j]);

        }
        Collections.sort(res);

        return res;
    }
}

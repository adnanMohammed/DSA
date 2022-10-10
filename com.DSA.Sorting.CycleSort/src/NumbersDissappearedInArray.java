import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersDissappearedInArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        for (int i : findDisappearedNumbers(nums)) {
            System.out.print(i + " ");
        }
    }

    //leetcode easy 448. Find All Numbers Disappeared in an Array
    public static List<Integer> findDisappearedNumbers(int[] nums) {
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
                res.add(j + 1);

        }
        return res;

    }

}

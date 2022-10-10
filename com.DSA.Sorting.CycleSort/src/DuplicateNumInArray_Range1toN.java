public class DuplicateNumInArray_Range1toN {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
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

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                return nums[j];
        }
        return -1;
    }
}

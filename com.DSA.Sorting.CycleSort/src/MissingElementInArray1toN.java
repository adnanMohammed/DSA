public class MissingElementInArray1toN {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(missingNumber(nums));
    }

    //leetCode 268. Missing Number
    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                i++;
            } else {
                int correct = nums[i] - 1;
                if (nums[correct] != nums[i]) {
                    //swap(nums,correct,i)
                    nums[correct] = nums[correct] + nums[i];
                    nums[i] = nums[correct] - nums[i];
                    nums[correct] = nums[correct] - nums[i];
                } else {
                    i++;
                }
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1)
                return j + 1;
        }
        return 0;
    }

    public static int missingNumberApproach2(int[] nums) {
        int index = 0;
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                count += 1;
                index = i;
                i++;
            } else {
                int correct = nums[i] - 1;
                if (nums[correct] != nums[i]) {
                    //swap(nums,correct,i)
                    nums[correct] = nums[correct] + nums[i];
                    nums[i] = nums[correct] - nums[i];
                    nums[correct] = nums[correct] - nums[i];
                } else {
                    i++;
                }
            }
        }
        return count == 0 ? 0 : index + 1;

    }

}

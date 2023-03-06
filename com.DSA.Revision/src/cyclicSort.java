/*
int index=0;
        int count=0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                count+=1;
                index=i;
                i++;
            }
            else {
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
        return count==0?0:index+1;
 */







public class cyclicSort {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(findMissingNumberFrom1toN(arr));
    }


    public static int findMissingNumberFrom1toN(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if ((nums[i] != i + 1) && (nums[i] != 0)) {
                //swap(nums,i,nums[i]-1)
                int correct = nums[i] - 1;
                nums[i] = nums[i] + nums[correct];
                nums[correct] = nums[i] - nums[correct];
                nums[i] = nums[i] - nums[correct];
            } else
                i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0)
                return j + 1;
        }
        return 0;
    }
}

public class maxNumberOfConsecutiveOnes {
    public static void main(String[] args) {
       int[] nums = {1,1,0,1,1,1};
        findMaxConsecutiveOnes(nums);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i : nums) {
            if (i == 1) {
                count += 1;
            } else {
                maxCount = maxCount > count ? maxCount : count;
                count = 0;
            }
        }
        maxCount = maxCount > count ? maxCount : count;
        return maxCount;
    }
}

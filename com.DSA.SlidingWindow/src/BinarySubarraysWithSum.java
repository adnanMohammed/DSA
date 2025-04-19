public class BinarySubarraysWithSum {

    public int numSubarraysWithSumOptimal(int[] nums, int goal) {
      return   numSubarraysWithSumOptimalHelper(nums,goal)-numSubarraysWithSumOptimalHelper(nums,goal-1);
    }

    public int numSubarraysWithSumOptimalHelper(int[] nums, int goal) {
        int count = 0, sum = 0, L = 0, R = 0, n = nums.length;
        if (goal < 0)
            return 0;
        while (R < n) {
            count += nums[R];

            while (count > goal) {
                count -= nums[L];
                L++;
            }
            sum += R - L + 1;
            R++;
        }
        return sum;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        //your code goes here
        int count = 0, n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int goalCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1)
                    goalCount++;

                if (goalCount == goal)
                    count++;
            }
        }
        return count;
    }
}


class BinarySubarraysWithSumMain{
    public static void main(String[] args) {
        BinarySubarraysWithSum sum = new BinarySubarraysWithSum();
        System.out.println( sum.numSubarraysWithSumOptimal(new int[]{1, 1, 0, 1, 0, 0, 1}, 3));
    }
}
public class CountnumberofNicesubarrays {
    public int numberOfOddSubarrays(int[] nums, int k) {
        //your code goes here
        int count = 0, n = nums.length;
        for (int i = 0; i <= n - k; i++) {
            int oddCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0)
                    oddCount++;

                if (oddCount == k)
                    count++;
            }
        }
        return count;
    }


    public int numberOfOddSubarraysOptimal(int[] nums, int k) {
        return   numberOfOddSubarraysOptimalHelper(nums,k)-numberOfOddSubarraysOptimalHelper(nums,k-1);
    }

    public int numberOfOddSubarraysOptimalHelper(int[] nums, int k) {
        int count = 0, sum = 0, L = 0, R = 0, n = nums.length;
        if (k < 0)
            return 0;
        while (R < n) {
            count += nums[R]%2;

            while (count > k) {
                count -= nums[L]%2;
                L++;
            }
            sum += R - L + 1;
            R++;
        }
        return sum;
    }
}


class CountnumberofNicesubarraysMain{
    public static void main(String[] args) {
        CountnumberofNicesubarrays n= new CountnumberofNicesubarrays();
        System.out.println(  n.numberOfOddSubarraysOptimal(new int[]{41,3,5},2));
    }
}
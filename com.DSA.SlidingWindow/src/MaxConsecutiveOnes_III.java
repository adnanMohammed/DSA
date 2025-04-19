import javax.print.DocFlavor;

public class MaxConsecutiveOnes_III {


    public int longestOnes(int[] nums, int k) {
        //your code goes here
        int maxLength=0;
        for (int i = 0; i < nums.length; i++) {
            int countZero=0;
            for (int j = i; j < nums.length ; j++) {

                if (nums[j]==0)
                    countZero++;

                if (countZero>k){
                    maxLength=Math.max(maxLength,j-i);
                    break;
                }
                else maxLength=Math.max(maxLength,j-i+1);
            }
        }
        return maxLength;
    }

    public int longestOnesBetter(int[] nums, int k) {
        int L = 0, R = 0, n = nums.length, maxLength = 0, zeroCount = 0;

        while (R < n) {
            if (nums[R] != 0 ) {
                maxLength = Math.max(maxLength, R - L + 1);
                R++;
            } else if (zeroCount < k) {
                zeroCount++;
                maxLength = Math.max(maxLength, R - L + 1);
                R++;
            }  else if (nums[R]==0 &&zeroCount == k) {
                if (nums[L] == 0)
                    zeroCount--;

                    L++;
            }
        }

        return maxLength;
    }
}



class MaxConsecutiveOnes_IIIMain {
    public static void main(String[] args) {
        MaxConsecutiveOnes_III mc = new MaxConsecutiveOnes_III();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        mc.longestOnesBetter(nums, k);
    }
}
import java.util.Arrays;

public class SmallestNumThanCurrentNum {
    public static void main(String[] args) {
        int[] nums={6,5,4,8};
      System.out.println( Arrays.toString( NumSmaller(nums)));
    }
    public static int[] NumSmaller(int[] nums) {
        int[] arr = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    sum += 1;
            }
            arr[i]=sum;
            sum=0;
        }
        return arr;
    }
}

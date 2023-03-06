import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //int[] nums = {-12, -3459, 2, 6, 7896, 0};

        int[] nums = {5,1,6,4,2};
        System.out.println(Arrays.toString(insertionSort(nums)));
        //System.out.println(MaxContigiousSubArraySum(nums));
        //System.out.println(MaxContigiousSubArraySumKadaneAlgo(nums));
    }

    public static int[] insertionSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int min=i;
            for (int j = i; j < nums.length; j++) {
                if(nums[j]<nums[min])
                    min=j;
            }

            if(min!=i){
                nums[min] = nums[min] + nums[i];
                nums[i] = nums[min] - nums[i];
                nums[min] = nums[min] - nums[i];
            }
        }
        return nums;
    }


    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j] + nums[j + 1];
                    nums[j + 1] = nums[j] - nums[j + 1];
                    nums[j] = nums[j] - nums[j + 1];
                    count += 1;
                }
            }
            if (count == 0)
                return nums;
        }
        return nums;
    }


    private static int MaxContigiousSubArraySumKadaneAlgo(int[] nums) {
        int sum = 0;
        int totalMaxSum = -1;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (totalMaxSum < sum)
                totalMaxSum = sum;

            if (sum < 0)
                sum = 0;

        }
        return totalMaxSum;
    }

    private static int MaxContigiousSubArraySum(int[] nums) {
        int totalMax = -1;
        for (int i = 0; i < nums.length; i++) {
            int indexMax = 0;
            for (int j = i; j < nums.length; j++) {
                indexMax = indexMax + nums[j];
                if (indexMax > totalMax)
                    totalMax = indexMax;
            }
        }
        return totalMax;
    }

    private static int[] ReverseArrayFromPos(int[] nums, int pos) {
        int s = pos + 1, e = nums.length - 1;
        while (s < e) {
            nums[s] = nums[s] + nums[e];
            nums[e] = nums[s] - nums[e];
            nums[s] = nums[s] - nums[e];
            s += 1;
            e -= 1;
        }
        return nums;
    }

    private static int[] ReverseArray(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            nums[s] = nums[s] + nums[e];
            nums[e] = nums[s] - nums[e];
            nums[s] = nums[s] - nums[e];
            s += 1;
            e -= 1;
        }
        return nums;
    }

    private static int[] NegativeNumbersAtBegining(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[index] = nums[index] + nums[i];
                nums[i] = nums[index] - nums[i];
                nums[index] = nums[index] - nums[i];
                index += 1;
            }
        }
        return nums;
    }


    private static int countDigits(int[] arr) {
        int countDigit = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (arr[i] < 0)
                value = value * (-1);
            int count = 0;
            while (value > 0) {
                value = value / 10;
                count += 1;
            }
            if (count % 2 == 0 && arr[i] != 0)
                countDigit += 1;
        }
        return countDigit;
    }


}
public class maximumSumSubArrayOfSizek {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8, 2, 9, 1};
        int res = maxSumSubArraySizeK(arr, 3);
    }


    //Sliding window
    //
    public static int maxSumSubArraySizeK(int[] arr, int k) {
        int i = 0, j = 0;
        int n = arr.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        while (j < n) {
            sum += arr[j];
            if (j - i + 1 < k)
                j++;
            else {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}

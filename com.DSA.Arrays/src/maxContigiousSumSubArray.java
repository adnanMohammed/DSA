public class maxContigiousSumSubArray {
    public static void main(String[] args) {
        //int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr = {-1, -2, 1, 3, -4};
        System.out.println("max SubArray=" + maxContigiousSumSubArray(arr, arr.length));
        //System.out.println("max SubArray=" + maxContigiousSumSubArray_KadenesAlgorithm(arr, arr.length));
    }

    //bruteForce solution O(N2) Time Complexity
    public static long maxContigiousSumSubArray(int[] arr, int n) {
        long max_sum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (max_sum < sum) {
                    max_sum = sum;
                }
            }
        }
        return max_sum;
    }

    //O(N) Time Complexity Kadene's Algorithm
    public static long maxContigiousSumSubArray_KadenesAlgorithm(int[] arr, int n) {
        int max_sum = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (max_sum < sum) {
                max_sum = sum;
            }
            if (sum < 0)
                sum = 0;

        }
        return max_sum;
    }

}

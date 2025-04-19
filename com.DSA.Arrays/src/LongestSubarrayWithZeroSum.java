import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        int res = getLongestZeroSumSubarrayLength(arr);
        System.out.println("res=" + res);
    }


    //optimal sol
    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int sum = 0, maxCount = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0)
                maxCount = i + 1;

            else if (!m.containsKey(sum))
                m.put(sum, i);
            else {
                int res = m.get(sum);
                maxCount = Math.max(maxCount, i - res);
            }
        }
        return maxCount;
    }
}

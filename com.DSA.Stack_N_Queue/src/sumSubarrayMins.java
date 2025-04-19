import java.util.Arrays;

public class sumSubarrayMins {
    //brute force O(n2)
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }
        return sum;
    }


}

class sumSubarrayMinsMain{
    public static void main(String[] args) {
     sumSubarrayMins sm=new sumSubarrayMins();
     int[] arr={3, 1, 2, 5};
     sm.sumSubarrayMins(arr);
    }
}

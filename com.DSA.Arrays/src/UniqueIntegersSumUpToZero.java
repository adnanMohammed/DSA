import java.util.Arrays;

public class UniqueIntegersSumUpToZero {
    public static void main(String[] args){
        int n=5;
       System.out.println(Arrays.toString( UniqueIntegerSum(n)));
    }
    public static int[] UniqueIntegerSum(int n) {
        int[] arr = new int[n];
        int num = n / 2;
        int s = 0, e = n - 1;
        while (s <= e) {
            arr[s] = -num;
            arr[e] = num;
            s += 1;
            e -= 1;
            num -= 1;
        }
        return arr;
    }
}

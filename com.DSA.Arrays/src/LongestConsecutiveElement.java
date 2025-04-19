import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestConsecutiveElement {
    public static void main(String[] args) {
        longestSuccessiveElements(new int[]{15,6,2,1,16,4,2,29,9,12,8,5,14,21,8,12,17,16,6,26,3});
    }

    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        Arrays.sort(a);
        a=IntStream.of(a).distinct().sorted().toArray();
        int counter=0;int max=0;
        for (int i = 1; i < a.length; i++) {
            int dif= a[i]-a[i-1];
            if(dif==1){
                counter++;
               max= Math.max(max, counter);
            }
            else
                counter=0;
        }
        return max+1;

    }
}

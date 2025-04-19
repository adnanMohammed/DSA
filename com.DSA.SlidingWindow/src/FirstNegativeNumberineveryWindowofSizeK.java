import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNumberineveryWindowofSizeK {

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        FirstNegativeNumberWindowofSizeKOpt(arr, k);
    }

    public static List<Integer> FirstNegativeNumberWindowofSizeKOpt(int[] arr, int k) {
        Queue<Integer> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        int i=0;int j=0;int n= arr.length;
        while (j<n){
            if (arr[j]<0)
                q.add(arr[j]);

            if(j-i+1 < k)
                j++;
            else {
                if(!q.isEmpty())
                    list.add(q.peek());
                else list.add(0);

                if(!q.isEmpty() && arr[i]==q.peek())
                    q.remove();
                i++; j++;

            }
        }
        return list;
    }


    //brute force
    public static List<Integer> FirstNegativeNumberWindowofSizeK(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i <= n - k; i++) {
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    list.add(arr[j]);
                    System.out.println(arr[j]);
                    break;
                }
            }
        }
        return list;
    }
}

import java.util.ArrayList;
import java.util.List;

public class AlternateNumbers {
    public static void main(String[] args) {
        int[] arr={1,2,-4,-5};
        alternateNumbers(arr);
    }

    public static int[] alternateNumbers(int []a) {
        // Write your code here.
        List<Integer> pos=new ArrayList();
        List<Integer> neg=new ArrayList();

        for (int i = 0; i < a.length; i++) {
            if(a[i]>=0)
                pos.add(a[i]);
            else
                neg.add(a[i]);
        }
        int j=0;
        for (int i = 0; i < a.length; i+=2) {
            a[i]=pos.get(j);
            a[i+1]=neg.get(j);
            j++;
        }
        return a;
    }
}

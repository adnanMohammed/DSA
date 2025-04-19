import java.util.*;
public class SuperiorElements {

    public static void main(String[] args) {
        superiorElements(new int[]{142 ,145, 41, 13, 41 });
    }

    public static List< Integer > superiorElements(int []a) {
        // Write your code here.
        int n = a.length;
        List<Integer> l = new ArrayList<Integer>();
        l.add(a[n - 1]);
        int max = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > max)
                l.add(a[i]);

            max = Math.max(max, a[i]);

        }
        return l;
    }
}

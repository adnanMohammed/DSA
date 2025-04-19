import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {
        Map<Integer,Integer> m=new HashMap<Integer,Integer>();

        int[] arr={6, 1, 1, 1, 2, 2, 3};
        for (int num:arr) {
            m.put(num,m.getOrDefault(num,0)+1);
        }



    }
}

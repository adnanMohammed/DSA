import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int n=5; int []book={4,1,2,3,1}; int target=5;
        readOptimized(n,book,target);
    }


    //Brute force 2 for loops
    public static String read(int n, int []book, int target){
        //O(n-1)
        for (int i = 0; i < n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                if(book[i]+book[j]==target)
                    return "YES";
            }
        }
        return "NO";
    }

    //using HashMap
    public static String readOptimized(int n, int []book, int target){
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();

        for (int i = 0; i <n ; i++) {
            if(m.containsKey(target-book[i]))
                return "YES";
            m.put(book[i],i );
        }
        return "NO";
    }

    //using 2 pointer approach
    public static String readOptimizedwithoutMap(int n, int []book, int target) {
        Arrays.sort(book);
        int s = 0, e = n - 1;
        while (s <= e) {
            int sum = book[s] + book[e];
            if (sum == target)
                return "YES";
            else if (sum < target)
                s++;
            else e--;
        }
        return "NO";
    }
}

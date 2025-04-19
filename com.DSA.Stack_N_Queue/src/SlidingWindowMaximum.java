import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int L = 0, R = 0, n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();
        while (R < n) {
            while (!q.isEmpty() && arr[R] > q.peekLast())
                q.removeLast();

            q.add(arr[R]);
            if (R - L + 1 < k)
                R++;

            else {
                l.add(q.peek());
                if (q.peekFirst() == arr[L])
                    q.remove();

                L++;
                R++;
            }
        }
        return l.stream().mapToInt(i -> i).toArray();
    }
}

class SlidingWindowMaximumMain{
    public static void main(String[] args) {
        SlidingWindowMaximum s=new SlidingWindowMaximum();
        int[] arr={609,894,552,690,-565,-260,31,-896,-179,-216,256,940,-253,430,983,803,782,993}; int k=4;
       int[] res= s.maxSlidingWindow(arr,k);
    }
}
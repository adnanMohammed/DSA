import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] arr) {
        int n=arr.length;
       Stack<Integer> s=new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            s.push(arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= s.peek())
                s.pop();

            if (s.isEmpty()) {
                s.add(arr[i]);
                arr[i] = -1;
            } else {
                int temp = s.peek();
                s.push(arr[i]);
                arr[i] = temp;
            }
        }
        return arr;
    }
}

class NextGreaterElement2Main{
    public static void main(String[] args) {
        NextGreaterElement2 ng=new NextGreaterElement2();
        int[] arr={3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        int[] ans=ng.nextGreaterElements(arr);
        System.out.println("ans="+ans);
    }
}

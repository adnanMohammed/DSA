import java.util.Stack;

public class NextLargerElement {
    //bruteForce
    public int[] nextLargerElement(int[] arr) {
        if (arr.length == 1)
            return new int[]{-1};

        int n = arr.length;
        int[] res = new int[n];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean isGreater = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isGreater = true;
                    res[count++] = arr[j];
                    break;
                }
            }
            if (!isGreater)
                res[count++] = -1;
        }
        res[count++]=-1;
        return res;
    }

    public int[] nextLargerElementOptimal(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] >= s.peek())
                s.pop();

            if (s.isEmpty()) {
                s.push(arr[i]);
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

class NextLargerElementMain{
    public static void main(String[] args) {
        NextLargerElement nl=new NextLargerElement();
        int[] arr={6,8,0,1,3};
        nl.nextLargerElementOptimal(arr);
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StockSpanProblem {
    public int[] stockSpanOptimal(int[] arr, int n) {
        Stack<int[]> st=new Stack();
        st.push(new int[]{arr[0],0});arr[0]=1;

        for (int i = 1; i < n; i++) {
            while(!st.isEmpty() && arr[i]>=st.peek()[0])
                st.pop();

            if (st.isEmpty()){
               int temp=arr[i];
               arr[i]=i+1;
               st.push(new int[]{temp,i});
            }else {
                int temp = arr[i];
                arr[i] = i - st.peek()[1];
                st.push(new int[]{temp, i});
            }
        }
        return arr;
    }
    public int[] stockSpan(int[] arr, int n) {
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {

            int j = i - 1;
            while (j >= 0 && arr[i] >= arr[j])
                j--;

            res[i] = i - j;
        }

        return res;
    }
}


class StockSpanProblemMain{
    public static void main(String[] args) {
    StockSpanProblem sp=new StockSpanProblem();
    int[] arr={7,2,1,3,3,1,8}; int n= arr.length;
    int[] res=sp.stockSpanOptimal(arr, n);
    }
}
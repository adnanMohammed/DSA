import java.util.Arrays;

public class ShortestJobFirst {
    public long solve(int[] bt) {
        //your code goes here
        Arrays.sort(bt);
        int sum=0,n=bt.length,total=0;
        for (int i = 0; i < n-1; i++) {
            sum+=bt[i];
            total+=sum;
        }
        int res=total/n;
        return res;
    }
}


class ShortestJobFirstMain {
    public static void main(String[] args) {
        ShortestJobFirst sf = new ShortestJobFirst();
        int[] bt = {9, 3, 1, 8, 2};
        long res = sf.solve(bt);
        System.out.println(res);
    }
}

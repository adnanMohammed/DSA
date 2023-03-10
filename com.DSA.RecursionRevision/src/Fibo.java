public class Fibo {
    public static void main(String[] args) {
        System.out.println(FibonacciRecusive(5));
    }




    public static int FibonacciLoop(int n) {
        int n1=0,n2=1;
        for (int i = 2; i <=n; i++) {
            int temp=n1;
             n1=n2;
             n2=temp+n2;

        }
        return n2;

    }

    public static int FibonacciRecusive(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return FibonacciRecusive(n - 1) + FibonacciRecusive(n - 2);
    }
}

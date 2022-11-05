public class NthFibonacciNumber {
    public static void main(String[] args) {
        //0 1 1 2 3 5 8 13 21 34 55
        int n = 5;
        //System.out.println(  FibonacciLoop(n));
        System.out.println(FibonacciRecusion(n));
    }

    private static int FibonacciRecusion(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return FibonacciRecusion(n - 2) + FibonacciRecusion(n - 1);
    }

    private static int FibonacciLoop(int n) {
        if (n <= 1)
            return n;
        else {
            int n_2 = 0;
            int n_1 = 1;
            int Fib_N=0;
            for (int i = 2; i <= n; i++) {
                Fib_N = n_2 + n_1;
                n_2 = n_1;
                n_1 = Fib_N;
            }
            return Fib_N;
        }

    }
}

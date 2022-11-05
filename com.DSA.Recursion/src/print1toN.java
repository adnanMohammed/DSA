public class print1toN {

    public static void main(String[] args) {
        int N=5;
        print1tooN(N);
    }
    public static void print1tooN(int N) {
        if (N == 1) {
            System.out.print(N+" ");
            return;
        } else {

            print1tooN(N - 1);
            System.out.print(N + " ");
        }

    }
}

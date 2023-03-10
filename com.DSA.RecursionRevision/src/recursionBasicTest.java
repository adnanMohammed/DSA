public class recursionBasicTest {
    public static void main(String[] args) {
        int n = 1;
        message(n);
    }



    public static void message(int n) {
        if (n == 5) {
            System.out.println(n);
            return;
        } else {
            System.out.println(n);
            message(n + 1);
            System.out.println(n);
        }
    }
}

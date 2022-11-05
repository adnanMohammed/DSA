public class RecursionExample {
    public static void main(String[] args) {
        printNumbers(1);
    }

    private static void printNumbers(int i) {
        //base condition
        if (i == 5) {
            return;
        }
        //body
        System.out.println(i);
        //recursive call
        printNumbers(i + 1);
    }
}

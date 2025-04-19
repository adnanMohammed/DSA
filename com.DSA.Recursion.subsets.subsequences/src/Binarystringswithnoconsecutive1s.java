public class Binarystringswithnoconsecutive1s {

    public static void main(String[] args) {
        int n = 4; // Change this value to the desired length of binary strings
        generateBinaryStrings(n);
    }

    public static void generateBinaryStrings(int n) {
        generateBinaryStringsHelper(n, "");
    }

    public static void generateBinaryStringsHelper(int n, String current) {
        if (n == 0) {
            System.out.println(current);
        } else {
            // Append '0' to the current string and recurse
            generateBinaryStringsHelper(n - 1, current + "0");

            // If the last character of the current string is '0',
            // append '1' and recurse
            if (current.isEmpty() || current.charAt(current.length() - 1) != '1') {
                generateBinaryStringsHelper(n - 1, current + "1");
            }
        }
    }

}

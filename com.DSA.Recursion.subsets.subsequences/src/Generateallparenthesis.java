import java.util.ArrayList;
import java.util.List;

public class Generateallparenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private static void generate(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 4; // Change this to the desired number of pairs
        List<String> validParentheses = generateParenthesis(n);

        System.out.println("Valid Parentheses Combinations for " + n + " pairs:");
        for (String s : validParentheses) {
            System.out.println(s);
        }
    }
}

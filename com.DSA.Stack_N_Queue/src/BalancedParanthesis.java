import java.util.Stack;

public class BalancedParanthesis {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
                s.push(str.charAt(i));

            else if (!s.isEmpty() && s.peek() == '(' && str.charAt(i) == ')')
                s.pop();
            else if (!s.isEmpty() && s.peek() == '{' && str.charAt(i) == '}')
                s.pop();
            else if (!s.isEmpty() && s.peek() == '[' && str.charAt(i) == ']')
                s.pop();
            else
            return false;
        }
        return s.isEmpty();
    }
}


class BalancedParanthesisMain {
    public static void main(String[] args) {
        BalancedParanthesis b = new BalancedParanthesis();
        boolean ans = b.isValid("()[{}()]");
        System.out.println("ans=" + ans);
    }
}
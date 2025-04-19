import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String nums, int k) {
        int n = nums.length();
        Stack<Character> s = new Stack<>();
        StringBuilder ans = new StringBuilder();
        if (n == k)
            return "";
        s.push(nums.charAt(0));

        for (int i = 1; i < n; i++) {
            if (k == 0)
                s.push(nums.charAt(i));
            else if (nums.charAt(i) == '0' && s.peek() == '0') {

            } else if (nums.charAt(i) < s.peek()) {
                k--;
                s.pop();
                s.push(nums.charAt(i));
            } else s.push(nums.charAt(i));
        }
        while (k > 0) {
            s.pop();
            k--;
        }

        while (!s.isEmpty()) {
            ans.append(s.pop());
        }
        String res = ans.reverse().toString();
        while (res.startsWith("0"))
            res = res.substring(1, res.length());

        return res;
    }
}


class RemoveKDigitsMain {
    public static void main(String[] args) {
        RemoveKDigits rk = new RemoveKDigits();
        String str ="541892";
        int k = 2;
       String res= rk.removeKdigits(str, k);
        System.out.println("res="+res);
    }
}
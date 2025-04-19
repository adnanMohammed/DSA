import java.util.ArrayList;
import java.util.List;

public class MoreSubsequence {
    public static void main(String[] args) {
        String a = "ab", b = "dd";
        moreSubsequence(a.length(), b.length(), a, b);
    }

    public static String moreSubsequence(int n, int m, String a, String b) {
        List<String> l1 = new ArrayList<>();
        int res1 = subsequenceHelper(a, "", l1);
        List<String> l2 = new ArrayList<>();
        int res2 = subsequenceHelper(b, "", l2);
        if (res1 == res2 || res1 > res2)
            return a;
        return b;
    }

    public static int subsequenceHelper(String str, String ans, List<String> list) {
        if (str.isEmpty()) {
            if (!list.contains(ans)) {
                list.add(ans);
                return 1;
            }
            return 0;
        }
        int left = subsequenceHelper(str.substring(1), ans + str.charAt(0), list);
        int right = subsequenceHelper(str.substring(1), ans, list);
        return left + right;
    }
}

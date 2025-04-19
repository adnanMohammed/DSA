import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s1 = "hgvoo";
        String s2 = "bnnff";
        isIsomorphic(s1, s2);

    }

    public static boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> charMap1 = new HashMap<>();
        Map<Character, Character> charMap2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (charMap1.containsKey(c1)) {
                if (charMap1.get(c1) != c2) {
                    return false;
                }
            } else {
                charMap1.put(c1, c2);
            }

            if (charMap2.containsKey(c2)) {
                if (charMap2.get(c2) != c1) {
                    return false;
                }
            } else {
                charMap2.put(c2, c1);
            }
        }

        return true;
    }
}

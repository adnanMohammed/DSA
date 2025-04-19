import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindowopt(String s, String t) {

        /* Variable to store the minimum
        length of substring found */
        int minLen = Integer.MAX_VALUE;

        /* Variable to store the starting index
        of the minimum length substring */
        int sIndex = -1;

        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) + 1);

        int tsize = m.size();
        int count = 0;
        int l = 0, r = 0;

        // Iterate through current window
        while (r < s.length()) {
            // Include the current character in the window
            if (m.get(s.charAt(r)) > 0) {
                count++;
            }
            m.put(s.charAt(r), m.get(s.charAt(r)) - 1);

            /* If all characters from t
            are found in current window */
            while (count == tsize) {

                /* Update minLen and sIndex
                if current window is smaller */
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                // Remove leftmost character from window
                m.put(s.charAt(l), m.get(s.charAt(l)) + 1);
                if (m.get(s.charAt(l)) > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }

        // Return minimum length substring from s
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }


    //better sol O(N);
    public String minWindow(String s, String t) {
        //your code goes here
        if (t.length() > s.length())
            return "";
        if (s.equals(t))
            return s;
        int count = 0, L = 0, R = 0, minLength = Integer.MAX_VALUE, startIndex = -1, n = s.length();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) + 1);

        int tcharSize = m.size();
        while (R < n) {
            if (!m.containsKey(s.charAt(R))) {
                m.put(s.charAt(R), -1);
                R++;
            } else if (m.containsKey(s.charAt(R))) {
                m.put(s.charAt(R), m.get(s.charAt(R)) - 1);
                if (m.get(s.charAt(R)) == 0)
                    count++;

                if (count == tcharSize) {
                    if (minLength > R - L + 1) {
                        startIndex = L;
                        minLength = R - L + 1;
                    }
                }
                while (count >= tcharSize) {
                    m.put(s.charAt(L), m.get(s.charAt(L)) + 1);
                    if (minLength > R - L + 1) {
                        startIndex = L;
                        minLength = R - L + 1;
                    }
                    if (m.get(s.charAt(L)) > 0)
                        count--;
                    L++;
                }
                R++;
            }
        }

        if (startIndex == -1)
            return "";

        return s.substring(startIndex, startIndex + minLength);
    }
}

class MinimumWindowSubstringMain {
    public static void main(String[] args) {
        MinimumWindowSubstring ms=new MinimumWindowSubstring();
        String s = "cabwefgewcwaefgcf" , t = "cae";
        System.out.println( ms.minWindowopt(s,t));
    }
}

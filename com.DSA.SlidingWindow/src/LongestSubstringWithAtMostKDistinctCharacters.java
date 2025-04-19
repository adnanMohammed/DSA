import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {



    public int kDistinctChar(String s, int k) {
        //your code goes here
        int n = s.length();
        int maxLength = 0;


        for (int i = 0; i < n; i++) {
            Map<Character, Integer> m = new HashMap<>();int sum = 0;
            for (int j = i; j < n; j++) {
                if (!m.containsKey(s.charAt(j)) && m.size() >= k)
                    break;

                m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1);
                sum++;
                maxLength = Math.max(maxLength, sum);
            }
        }

        return maxLength;
    }

    public int kDistinctCharOptimized(String s, int k) {
        Map<Character, Integer> m = new HashMap<>();
        int L = 0, R = 0, n = s.length(), maxLength = 0;
        while (R < n) {

            if (m.size() >= k) {
                if (m.containsKey(s.charAt(R))) {
                    m.put(s.charAt(R), m.get(s.charAt(R)) + 1);
                    maxLength = Math.max(maxLength, R - L + 1);
                    R++;
                } else {
                    m.put(s.charAt(L), m.get(s.charAt(L)) - 1);
                    if (m.get(s.charAt(L)) == 0)
                        m.remove(s.charAt(L));

                    L++;
                }
            } else {
                m.put(s.charAt(R), m.getOrDefault(s.charAt(R), 0) + 1);
                maxLength = Math.max(maxLength, R - L + 1);
                R++;

            }
        }
        return maxLength;
    }
}


class LongestSubstringWithAtMostKDistinctCharactersMain {
    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters l = new LongestSubstringWithAtMostKDistinctCharacters();
        String s = "aabacddefg" ; int k = 3;
        l.kDistinctCharOptimized(s,k);
    }
}
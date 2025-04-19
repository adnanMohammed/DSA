import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        //your code goes here
        int maxLength = 0, n = s.length(), L = 0, R = 0;
        Map<Character, Integer> m = new HashMap<>();
        while (R < n) {
            int maxFrequency = 0;
            m.put(s.charAt(R), m.getOrDefault(s.charAt(R), 0) + 1);
            Collection<Integer> value = m.values();
            for (int i : value) {
                maxFrequency = Math.max(maxFrequency, i);
            }
            if (R - L + 1 - maxFrequency <= k) {
                maxLength = Math.max(maxLength, R - L + 1);
                R++;
            } else {
                while (R - L + 1 - maxFrequency > k) {
                    m.put(s.charAt(L), m.get(s.charAt(L)) - 1);
                    L++;
                    Collection<Integer> value1 = m.values();
                    for (int i : value1) {
                        maxFrequency = Math.max(maxFrequency, i);
                    }
                }
                R++;
            }
        }
        return maxLength;
    }
}


class LongestRepeatingCharacterReplacementMain{
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement r=new LongestRepeatingCharacterReplacement();
        String s = "BAABAABBBAAA" ; int k = 2;
        r.characterReplacement(s,k);
    }
}
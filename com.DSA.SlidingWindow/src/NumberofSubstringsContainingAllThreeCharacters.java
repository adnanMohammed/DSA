public class NumberofSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        //your code goes here
        String check = "";
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i; j < s.length(); j++) {
                check = check + s.charAt(j);
                if (check.length() >= 3 && check.contains("a") && check.contains("b") && check.contains("c"))
                    count++;
            }
            check = "";
        }
        return count;
    }

    public int numberOfSubstringsOptimal(String s) {
        int L = 0, R = 0, n = s.length(), a = 0, b = 0, c = 0, count = 0;

        while (R < n) {
            if (s.charAt(R) == 'a') a++;
            if (s.charAt(R) == 'b') b++;
            if (s.charAt(R) == 'c') c++;

            while (a >= 1 && b >= 1 && c >= 1) {
                count += n - R;

                if (s.charAt(L) == 'a') a--;
                if (s.charAt(L) == 'b') b--;
                if (s.charAt(L) == 'c') c--;
                L++;
            }
            R++;
        }

        return count;
    }

    public int numberOfSubstringsOptimal2(String s) {
        int L = 0, R = 0, n = s.length(), count = 0;
        int[] charac = new int[3];
        while (R < n) {
            charac[s.charAt(R) - 'a']++;
            while (charac[0] >= 1 && charac[1] >= 1 && charac[2] >= 1) {
                count += n - R;
                charac[s.charAt(L) - 'a']--;
                L++;
            }
            R++;
        }
        return count;
    }
}


class NumberofSubstringsContainingAllThreeCharactersMain {
    public static void main(String[] args) {
        NumberofSubstringsContainingAllThreeCharacters num = new NumberofSubstringsContainingAllThreeCharacters();
        String s = "abcba";
        System.out.println(num.numberOfSubstringsOptimal2(s));
    }
}
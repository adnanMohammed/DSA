public class FirstOccurrencePattern {

    public static void main(String[] args) {
      String  text = "gffggg";
        String pattern = "gfg";
        System.out.println(findMatching(text,pattern));
    }
    public static int findMatching(String text, String pat) {
        if (pat.length() > text.length())
            return -1;
        if (pat.length() == text.length()) {
            return text.equals(pat) ? 0 : -1;
        }

        for (int i = 0; i <= text.length() - pat.length(); i++) {
            if (text.substring(i, i + pat.length()).equals(pat))
                return i;
        }
        return -1;
    }
}

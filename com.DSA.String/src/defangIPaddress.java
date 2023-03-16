import java.util.*;

public class defangIPaddress {
    public static void main(String[] args) {
      String word1 = "   fly me   to   the moon  ";
        lengthOfLastWord(word1);
    }

    public static int lengthOfLastWord(String s) {
        String newSentence = s.trim();
        int count = 0;
        for (int i = newSentence.length() - 1; i >= 0; i--) {
            if (newSentence.charAt(i) != ' ') {
                count += 1;
            } else {
                return count;
            }
        }
        return count;
    }


    public static String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        String str = "";
        if (word1Length <= word2Length) {
            for (int i = 0; i < word1.length(); i++) {
                str = str + word1.charAt(i) + word2.charAt(i);
            }
            if (word1Length != word2Length)
                str = str + word2.substring(word1.length(), word2.length());
        } else {
            for (int i = 0; i < word2.length(); i++) {
                str = str + word1.charAt(i) + word2.charAt(i);
            }
            str = str + word1.substring(word2.length(), word1.length());
        }
        return str;
    }
    public static  boolean checkOnesSegment(String s) {
        if (s.contains("11"))
            return true;
        else return false;
    }

    public static int maxRepeatingSol(String s, String w) {
        if(w.length()>s.length()) return 0;
        int ans=0;
        StringBuilder sb=new StringBuilder("");
        while(sb.length()<=s.length()){
            sb.append(w);
            if(s.contains(sb)) ans++;
            else break;
        }
        return ans;
    }
    public static int maxRepeating(String sequence, String word) {
        int count=0;
        for (int i = 0; i < sequence.length() ; i++) {
            try{
                if(sequence.substring(i,i+word.length()).equals(word)){
                    count+=1;
                    i=i+word.length()-1;
                }
            }
            catch(Exception e){
                return count;
            }
        }
        return count;
    }

    public static String reverseWords(String s) {
        String formSentence="";
        String[] word=s.split(" ");
        for(String each:word){
            StringBuilder sb=new StringBuilder(each);
            sb.reverse();
            formSentence=formSentence+sb.toString()+" ";
        }
            return formSentence.trim();
    }

    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String str : patterns) {
            if (word.contains(str))
                count += 1;

        }
        return count;
    }



    public static boolean halvesAreAlike(String s) {
        int half = s.length() / 2;
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2, s.length());
        int rescount = 0;
        int secResCount = 0;
        for (int i = 0; i < firstHalf.length(); i++) {
            String res = firstHalf.charAt(i) + "";
            String secResult = secondHalf.charAt(i) + "";

            if (res.equalsIgnoreCase("a") || res.equalsIgnoreCase("e") || res.equalsIgnoreCase("i") || res.equalsIgnoreCase("o") || res.equalsIgnoreCase("u")) {
                rescount += 1;
            }
            if (secResult.equalsIgnoreCase("a") || secResult.equalsIgnoreCase("e") || secResult.equalsIgnoreCase("i") || secResult.equalsIgnoreCase("o") || secResult.equalsIgnoreCase("u")) {
                secResCount += 1;
            }
        }
        if (rescount == secResCount)
            return true;
        else return false;
    }


    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a1 = "", a2 = "";
        for (String s1 : word1) {
            a1 = a1 + s1;
        }
        for (String s1 : word2) {
            a2 = a2 + s1;
        }
        if (a1.equals(a2))
            return true;
        else return false;

    }

    public static String sortSentence(String s) {
        String[] s1 = s.split(" ");
        Map<Integer, String> m = new HashMap<Integer, String>();
        for (int i = 0; i < s1.length; i++) {
            String s2 = s1[i];
            String value = s2.substring(0, s2.length() - 1);
            int key = Integer.parseInt(s2.charAt(s2.length() - 1) + "");
            m.put(key, value);
        }
        String res = "";
        for (int i = 1; i <= m.size(); i++) {
            res = res + m.get(i) + " ";

        }

        return res.trim();
    }

    public static String interpret(String command) {
            String s=command.replace("()","o");
         return    s.replace("(al)","al");
    }

    public static String restoreString(String s, int[] indices) {
        Map<Integer, Character> m = new HashMap<Integer, Character>();
        //  char[] ch=s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            m.put(indices[i], s.charAt(i));
        }
        String res = "";
        for (int i = 0; i < m.size(); i++) {
            res += m.get(i);
        }
        return res;
    }

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");

    }
}

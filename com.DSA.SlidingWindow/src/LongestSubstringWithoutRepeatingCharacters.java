public class LongestSubstringWithoutRepeatingCharacters {
    public int longestNonRepeatingSubstring(String s) {
        //your code goes here
        if (s.length()==1)
            return 1;

        int R=1; String subString=s.charAt(0)+"";
        int maxLength=1;
        while (R< s.length()){
            if (!subString.contains(s.charAt(R)+"")){
                subString+=s.charAt(R);
                R++;
               maxLength= Math.max(maxLength,subString.length());
            }
            else {
                while (!s.isEmpty() && subString.contains(s.charAt(R)+""))
                 subString=   subString.substring(1,subString.length());

            }
        }

        return maxLength;
    }
}

class LongestSubstringWithoutRepeatingCharactersMain{
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sc=new LongestSubstringWithoutRepeatingCharacters();
        String  S = "abcddabac";
        int res=sc.longestNonRepeatingSubstring(S);
        System.out.println("res="+res);
    }
}

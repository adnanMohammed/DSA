public class Main {
    public static void main(String[] args) {

        System.out.println(  ispalindrome("MoM"));

    }

    public static boolean ispalindrome(String str) {
        char[] ch = str.toCharArray();
        String res = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            res += ch[i];
        }
        if (str.equals(res))
            return true;
        else return false;
    }
}
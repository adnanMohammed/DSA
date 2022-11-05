public class RemoveA {
    public static void main(String[] args) {
        String str="baccad";
        System.out.println(RemoveCharAInBodyKunal(str,""));
        //System.out.println(RemoveCharAInBody(str,0));
    }

    public static String RemoveCharA(String str, String ans, int index) {
        if (index == str.length()) {
            return ans;
        } else if (str.charAt(index) != 'a') {
            ans += str.charAt(index);
            return RemoveCharA(str, ans, index + 1);
        } else
            return RemoveCharA(str, ans, index + 1);
    }

    //"baccad"
    public static String RemoveCharAInBody(String str,int index) {
        String ans = "";
        if (index == str.length()) {
            return ans;
        } else if (str.charAt(index) != 'a') {
            ans += str.charAt(index);
            return ans+RemoveCharAInBody(str, index + 1);
        } else
            return RemoveCharAInBody(str, index + 1);
    }

    //"baccad"
    public static String RemoveCharAInBodyKunal(String str,String ans) {
        if(str.isEmpty())
            return ans;
        else{
            if(str.charAt(0)!='a'){
                ans+=str.charAt(0);
                return RemoveCharAInBodyKunal(str.substring(1),ans);
            }
            else{
                return RemoveCharAInBodyKunal(str.substring(1),ans);
            }
        }

    }
}

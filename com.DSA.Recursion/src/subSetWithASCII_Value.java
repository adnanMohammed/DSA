public class subSetWithASCII_Value {
    public static void main(String[] args) {
        char c='a';//97
        char c1='A';//65
        char c2='0';//48
        subsetASCII("abc","");
    }

    public static void subsetASCII(String str,String ans){
        if (str.isEmpty()) {
            System.out.print("'"+ans+"',");
            return;
        } else {
            subsetASCII(str.substring(1), ans + str.charAt(0));
            subsetASCII(str.substring(1), ans);
            subsetASCII(str.substring(1), (ans + (str.charAt(0)+0)));
        }

    }
}

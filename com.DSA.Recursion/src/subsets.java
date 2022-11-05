import java.util.ArrayList;

public class subsets {
    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
       for(String i: subsetStringArrayList(str, "")){
           System.out.print(i+",");
       }
       // subsetString(str, "");
        System.out.println();
        //subsetString2(str, "");
    }

    private static ArrayList<String> subsetStringArrayList(String str, String ans) {
        ArrayList<String> al = new ArrayList<>();
        if (str.isEmpty()) {
            // System.out.print("'"+ans+"',");
            al.add(ans);
            return al;
        } else {
            al.addAll(subsetStringArrayList(str.substring(1), ans + str.charAt(0)));
            al.addAll(subsetStringArrayList(str.substring(1), ans));
        }
        return al;
    }


    private static void subsetString(String str, String ans) {
        if (str.isEmpty()) {
            System.out.print("'"+ans+"',");
            return;
        } else {
            subsetString(str.substring(1), ans + str.charAt(0));
            subsetString(str.substring(1), ans);
        }
    }


    private static void subsetString2(String str, String ans) {
        if (str.isEmpty()) {
            System.out.print("'" + ans + "',");
            return;
        } else {
            subsetString2(str.substring(1), ans);
            subsetString2(str.substring(1), ans + str.charAt(0));
        }
    }

}

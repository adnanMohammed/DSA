import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
      subseqASCII("abc", "");
    }

    public static void subseqASCII(String proc, String unproc) {
        if (proc.isEmpty()) {
            System.out.print("'" + unproc + "',");
            return;
        } else {
            char ch = proc.charAt(0);
            subseqASCII(proc.substring(1), unproc + ch);
            subseqASCII(proc.substring(1), unproc + (ch + 0));
            subseqASCII(proc.substring(1), unproc);
        }
    }


    //void return type by using sout;
    public static void subseq(String proc, String unproc) {
        if (proc.isEmpty()) {
            System.out.print("'" + unproc + "',");
            return;
        } else {
            char ch = proc.charAt(0);
            subseq(proc.substring(1), unproc + ch);
            subseq(proc.substring(1), unproc);
        }
    }

    //ArrayList return type and uisng it in parameters
    public static ArrayList<String> subseqArrayListinParameters(String proc, String unproc, ArrayList<String> al) {
        if (proc.isEmpty()) {
            al.add(unproc);
            return al;
        } else {
            char ch = proc.charAt(0);
            subseqArrayListinParameters(proc.substring(1), unproc + ch, al);
            return subseqArrayListinParameters(proc.substring(1), unproc, al);
        }
    }


    //ArrayList return type and uisng it in body
    public static ArrayList<String> subseqArrayList(String proc, String unproc) {
        ArrayList<String> al = new ArrayList<String>();
        if (proc.isEmpty()) {
            al.add(unproc);
            return al;
        } else {
            char ch = proc.charAt(0);
            al.addAll(subseqArrayList(proc.substring(1), unproc + ch));
            al.addAll(subseqArrayList(proc.substring(1), unproc));
            return al;
        }
    }
}

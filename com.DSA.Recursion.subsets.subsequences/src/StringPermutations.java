import java.util.ArrayList;

public class StringPermutations {

    public static void main(String[] args) {
       /* for (String ans : permutationArrayList("", "abc")) {
            System.out.print(ans + ",");
        }*/
        permutation("","abc");
    }

    public static void permutation(String proc, String unproc) {
        if (unproc.isEmpty()) {
            System.out.print(proc + ",");
            return;
        }
        char ch = unproc.charAt(0);
        for (int i = 0; i <= proc.length(); i++) {
            String f = proc.substring(0, i);
            String s = proc.substring(i, proc.length());
            permutation(f + ch + s, unproc.substring(1));
        }

    }

    public static ArrayList<String> permutationArrayList(String proc, String unproc) {
        if (unproc.isEmpty()) {
            ArrayList<String> al = new ArrayList<String>();
            al.add(proc);
            return al;
        } else {
            ArrayList<String> eal = new ArrayList<String>();
            char ch = unproc.charAt(0);
            for (int i = 0; i <= proc.length(); i++) {
                String f = proc.substring(0, i);
                String s = proc.substring(i, proc.length());
                eal.addAll(permutationArrayList(f + ch + s, unproc.substring(1)));
            }
            return eal;
        }

    }
}

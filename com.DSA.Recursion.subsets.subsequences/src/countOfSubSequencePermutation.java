import java.util.ArrayList;

public class countOfSubSequencePermutation {
    public static void main(String[] args) {
        System.out.println(permutationcount1("", "abc"));
    }

    public static int permutationcount1(String proc, String unproc) {
        if (unproc.isEmpty()) {
            System.out.print(proc + ",");
            return 1;
        }
        int count = 0;
        char ch = unproc.charAt(0);
        for (int i = 0; i <= proc.length(); i++) {
            String f = proc.substring(0, i);
            String s = proc.substring(i, proc.length());
            count = count + permutationcount1(f + ch + s, unproc.substring(1));
        }
        return count;
    }

    public static int permutationArrayList(String proc, String unproc, int count) {
        if (unproc.isEmpty()) {
            ArrayList<String> al = new ArrayList<String>();
            al.add(proc);
            return count;
        } else {
            ArrayList<String> eal = new ArrayList<String>();
            char ch = unproc.charAt(0);
            for (int i = 0; i <= proc.length(); i++) {
                String f = proc.substring(0, i);
                String s = proc.substring(i, proc.length());
                permutationArrayList(f + ch + s, unproc.substring(1), count + 1);
            }
            return count;
        }

    }

    public static int permutationcount(String proc, String unproc) {
        if (unproc.isEmpty()) {
            // System.out.print(proc + ",");
            return 1;
        }
        char ch = unproc.charAt(0);
        int count = 0;
        for (int i = 0; i <= proc.length(); i++) {
            String f = proc.substring(0, i);
            String s = proc.substring(i, proc.length());
            count = count + permutationcount(f + ch + s, unproc.substring(1));
        }
        return count;
    }
}

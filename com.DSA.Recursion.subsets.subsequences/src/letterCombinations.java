import java.util.ArrayList;
import java.util.List;

public class letterCombinations {

    public static void main(String[] args) {
        pad("","abc");
      for (String res : padAL("", "67")) {
            System.out.print(res + ",");
        }
    }



    public static void pad(String proc, String unproc) {
        if (unproc.isEmpty()) {
            System.out.print(proc + ",");
            return;
        }
        int digit =  unproc.charAt(0) - 48;
        int range = 0;
        int rangeTill = 0;
        if (digit == 8 || digit == 9) {
            range = ((digit - 2) * 3) + 1;
        } else {
            range = (digit - 2) * 3;
        }
        if (digit == 7 || digit == 9) {
            rangeTill = range + 4;
        } else {
            rangeTill = range + 3;
        }

        for (int i = range; i < rangeTill; i++) {
            char ch = (char) (i + 97);
            pad(proc + ch, unproc.substring(1));
        }
    }

    public static List<String> padAL(String proc, String unproc) {
        if (unproc.isEmpty()) {
            //  System.out.println(proc);
            ArrayList<String> al = new ArrayList<>();
            al.add(proc);
            return al;
        }
        int digit = unproc.charAt(0) - 48;
        ArrayList<String> alouter = new ArrayList<>();
        int range = (digit - 2) * 3;
        int rangetill = range + 3;
        if (digit == 8 || digit == 9) {
            range = ((digit - 2) * 3) + 1;
        } else {
            range = (digit - 2) * 3;
        }
        if (digit == 7 || digit == 9) {
            rangetill = range + 4;
        } else {
            rangetill = range + 3;
        }
        for (int i = range; i < rangetill; i++) {
            char ch1 = (char) (i + 97);
            alouter.addAll(padAL(proc + ch1, unproc.substring(1)));
        }
        return alouter;
    }
}

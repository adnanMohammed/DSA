import java.util.ArrayList;

public class Test1 {

    public static void main(String[] args) {
        for (String res : test("", "23")) {
            System.out.print(res + ",");
        }
        System.out.println();

    }

    public static ArrayList<String> test(String proc, String unproc) {
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
            alouter.addAll(test(proc + ch1, unproc.substring(1)));
        }
        return alouter;
    }
}

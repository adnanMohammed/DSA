import java.util.ArrayList;

public class DiceThrow {
    public static void main(String[] args) {
        for (String str : diceReturnArrayList("", 4)) {
            System.out.print(str + ",");
        }
        System.out.println();
    }

    public static void dice(String p, int target) {
        if (target == 0) {
            System.out.print(p + " ");
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p + i, target - i);
        }
    }

    public static ArrayList<String> diceReturnArrayList(String p, int target) {
        if (target == 0) {
            ArrayList<String> al = new ArrayList<>();
            //  System.out.print(p+" " );
            al.add(p);
            return al;
        }

        ArrayList<String> outerAl = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            outerAl.addAll(diceReturnArrayList(p + i, target - i));
        }
        return outerAl;
    }
}

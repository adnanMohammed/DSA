import java.util.ArrayList;

public class ArrayList_2D {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int val = 0;
        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<Integer>());
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {

            ArrayList<Integer> i1 = list.get(i);
            for (int j = 0; j < 4; j++) {

                i1.add(val++);
            }

        }

        System.out.println(list);
    }
}

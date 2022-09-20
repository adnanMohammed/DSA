import java.util.ArrayList;

public class reverseArrayFromPos {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        int pos = 2;
        reverArrayFromPos(arr, pos);
    }

    private static void reverArrayFromPos(ArrayList<Integer> arr, int pos) {
        int[] a1 = new int[arr.size() - (pos + 1)];
        int inc = 0;
        for (int i = pos + 1; i < arr.size(); i++) {
            a1[inc] = arr.get(i);
            inc = inc + 1;
        }
        int val = a1.length - 1;
        for (int i = 0; i < a1.length / 2; i++) {
            a1[i] = a1[i] + a1[val - i];
            a1[val - i] = a1[i] - a1[val - i];
            a1[i] = a1[i] - a1[val - i];

        }
        int inc12 = 0;
        for (int i = pos + 1; i < arr.size(); i++) {

            arr.set(i, a1[inc12]);
            inc12 = inc12 + 1;
        }

    }
}

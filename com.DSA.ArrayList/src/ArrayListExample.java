import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        System.out.println("get()=" + al.get(0));
        System.out.println("size=" + al.size());
        al.set(0, 5);
        System.out.println(al.toString());
        al.clear();
        System.out.println(al.isEmpty());
        al.add(6);
        al.add(7);
        System.out.println(al.remove(0));
        System.out.println(al.indexOf(7));
        System.out.println(al.contains(50));

    }
}

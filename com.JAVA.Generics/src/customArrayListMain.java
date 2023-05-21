import java.util.ArrayList;
import java.util.List;

public class customArrayListMain {
    public static void main(String[] args) {
        customArrayList l=new customArrayList<>();
        l.add(1);l.add(2);l.add(3);l.add(4);l.add(5);l.add(6);
        l.add("true");
        System.out.println(   l.size());
        l.add(true);
        l.add(1.1);
        l.add(10l);
        l.add(1.11f);
        l.remove(0);
        l.contains("true");






      /*  List l = new ArrayList();
        l.add(10);
        l.add("adnan");
        l.add(true);
        l.add(10.0f);
        l.add(10l);
        l.remove(0);
        l.remove("adnan");
        l.size();
        l.isEmpty();
        l.contains(10);
        l.clear();
        l.get(0).equals("10");
        customArrayList l=new customArrayList();
        l.add(1);l.add(2);l.add(3);l.add(4);l.add(5);//l.add(6);l.add(7);l.add(8);l.add(9);l.add(10);l.add(11);l.add(12);l.add(13);
        l.remove(0);
        System.out.println( l.size());
        System.out.println(l.contains(15));
        System.out.println(l.get(8));
        l.clear();
        System.out.println(l.get(8));
        System.out.println(l.isEmpty());*/


    }
}

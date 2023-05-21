import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add(1);c.add(12);c.add("adnan");c.add(true);c.add(1);c.add(1);

        Iterator it= c.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }
    }
}

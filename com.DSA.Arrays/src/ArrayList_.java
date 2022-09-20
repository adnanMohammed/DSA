import java.util.ArrayList;

public class ArrayList_ {
    public static void main(String[] args){
        ArrayList list=new ArrayList();
        list.add(1);
        list.add("adnan");
        list.add(1);
        list.add(1);
        list.add(true);
        list.add(12);
        list.add('1');
        System.out.println(list);

        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        for (int i:arr) {
            System.out.print(i+", ");
        }
    }
}

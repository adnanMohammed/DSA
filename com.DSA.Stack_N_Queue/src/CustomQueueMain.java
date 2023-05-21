import java.util.LinkedList;
import java.util.Queue;

public class CustomQueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue q = new CustomQueue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(11);
        q.add(12);
        q.add(13);
        System.out.println(q.peek());
        System.out.println(q.empty());
        System.out.println(q.search(30));
        q.remove();
        q.remove();
        q.remove();
        System.out.println("-------------------");
        Queue q1=new LinkedList();
        q1.add(10);
        q1.add(20);
        q1.add(30);
        q1.add(40);
        q1.add(50);
        q1.add(60);
        System.out.println(q1.peek());
        System.out.println(q1.isEmpty());
        CustomStackGeneric<Integer> cs=new CustomStackGeneric<>();
        cs.push(10);
        cs.push(20);
        cs.push(30);
        cs.push(40);
        cs.push(50);
        cs.push(60);


    }
}

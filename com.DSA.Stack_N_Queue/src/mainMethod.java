import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class mainMethod {

    public static void main(String[] args) {
      Stack<Integer> st = new Stack<Integer>();
        //   st.pop();
     // st.peek();
      st.empty();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.pop();
        System.out.println(st.empty());
        System.out.println(st.size());//3
        System.out.println(st.peek());//30
        System.out.println(st.search(1));
        System.out.println("--------");

       Queue<Integer> q = new LinkedList<>();
       Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new PriorityQueue<>();
        Queue<Integer> q3 = new ArrayBlockingQueue<>(10);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println(q.remove());
        System.out.println(q.peek());//returns first element/the element which is set to be removed next
        System.out.println(q.poll());//removes the first element
        System.out.println(q.element());//returns head of the queue/ returns first element
        System.out.println(q.offer(30));//adds value or inserts the data
        System.out.println(q.offer(35));
        System.out.println(q.offer(40));
        q.clear();
        System.out.println("---------------------------");
        //System.out.println(q.remove());//throws exception if Queue is empty
        System.out.println(q.poll());//removes first element if available else returns null
        q.remove();
        System.out.println(q.peek());//does not throw an exception if Queue is empty

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        dq.add(2);
        dq.add(3);
        dq.add(4);
        dq.addFirst(0);
        dq.addLast(5);
        dq.remove();
        dq.removeFirst();
        dq.removeLast();
        System.out.println(   dq.peek());
        dq.poll();


    }
}

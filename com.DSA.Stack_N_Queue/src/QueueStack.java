import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Implement Stack using Queue
public class QueueStack {
    Queue<Integer> q = null;

    public QueueStack() {
        q = new LinkedList<>();
    }


    public void push(int x) {
        int s=q.size();
        q.add(x);

        for (int i = 0; i < s ; i++) {
            q.add(q.poll());
        }
    }


    public int pop() {
        if (q.isEmpty())
            return -1;
       return q.poll();
    }


    public int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }


    public boolean isEmpty() {
        return q.isEmpty();
    }
}


class QueueStackMain {
    public static void main(String[] args) {
        QueueStack qs=new QueueStack();
        qs.push(1);
        qs.push(2);
        qs.push(3);
        qs.push(4);
        qs.push(2);

    }
}
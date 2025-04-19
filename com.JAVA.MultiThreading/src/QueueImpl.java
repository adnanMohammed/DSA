import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {

    private Queue<Integer> q = null;
    private int capacity = 0;
    private int queueSize = 0;

    public QueueImpl(int capacity) {
        this.capacity = capacity;
        q = new LinkedList<Integer>();
    }

    //t1
    public boolean add(int data) {
        synchronized (q) {
            while (q.size() == capacity) {
                //doSomething
                try {

                    System.out.println("add-----");
                    q.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queueSize++;
            q.add(data);
           q.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (q) {
           while (q.size()<1) {
                try {
                    System.out.println("remove-----");
                    q.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queueSize--;
            int rem=q.remove();
            q.notifyAll();
            return rem;

        }
    }
}

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer_Consumer_BlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        System.out.println(Thread.currentThread().getName()+" queue size="+queue);
        Thread producer = new Thread(
                () -> {
                    try {
                        for (int i = 1; i <= 10; i++) {
                            queue.put(i);
                            System.out.println(Thread.currentThread().getName()+" Producer Thread producing the data="+i+" and queue size="+queue.size());
                            Thread.sleep(2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        Thread consumer = new Thread(
                () -> {
                    try {
                        for (int i = 1; i <= 10; i++) {
                            int data=queue.take();
                            System.out.println(Thread.currentThread().getName()+" consumer thread consuming the data="+data);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
        );
        producer.start();
        consumer.start();
      /*  try {
            producer.join();
            consumer.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }*/
    }
}

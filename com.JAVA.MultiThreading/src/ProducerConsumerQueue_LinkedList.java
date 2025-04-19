import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerQueue_LinkedList {
    public static void main(String[] args) {
        Object lock = new Object();
        Queue<Integer> queue = new LinkedList<Integer>();
        int queueSize = 10;
        Thread producer = new Thread(
                () -> {
                    int counter=0;
                    while (true) {
                        synchronized (lock) {
                            //while Queue is full wait for consumer to consume..
                            try {
                                while (queue.size() >= queueSize) {
                                    System.out.println(Thread.currentThread().getName() + " As the Queue is full, waiting for consumer to consume the data");
                                    lock.wait();
                                }
                                //Once the data is added to the queue, consumer should be notified to consume
                                queue.offer(counter++);
                                Thread.sleep(2000);
                                System.out.println(Thread.currentThread().getName() + " Data is added to the queue, counter=" + counter + ", Queue Size=" + queue.size());
                                lock.notifyAll();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }

                });
        Thread consumer = new Thread(
                () -> {
                    while (true) {
                        synchronized (lock) {
                            //while Queue is empty wait for produer to produce the data...
                            try {
                                while (queue.size() <= 0) {
                                    System.out.println(Thread.currentThread().getName() + " As the Queue is empty, waiting for producer to produce the data");
                                    lock.wait();
                                }
                                //Once the data is removed to the queue, producer should be notified to produce the data
                                queue.poll();
                                Thread.sleep(1000);
                                System.out.println(Thread.currentThread().getName() + " Data is consumed from the queue, Queue Size=" + queue.size());
                                lock.notifyAll();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });
        producer.start();
        consumer.start();

    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoresExample {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        ExecutorService executorService= Executors.newFixedThreadPool(50);
        for (int i = 1; i <=1000 ; i++) {
            executorService.execute(()->{

                System.out.println("Hello World");
                System.out.println("I am planning to sleep");
                semaphore.acquireUninterruptibly();
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                semaphore.release();
                System.out.println("I slept");
            });

        }
    }
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TypesOfPools {

    public static void main(String[] args) {
        //New Fixed Thread Pool

        ExecutorService es = Executors.newFixedThreadPool(10);
        ExecutorService es1 = Executors.newCachedThreadPool();
        ScheduledExecutorService es2 = Executors.newScheduledThreadPool(10);
        ExecutorService es3 = Executors.newSingleThreadExecutor();

        //Fixed Thread Pool which has 10 threads
        for (int i = 0; i < 100; i++) {
            es.submit(new AddNumbersTask());
        }

        //Cached Thread Pool creates one Thread per task and reuses the created Thread if available for executing following tasks if
        for (int i = 0; i < 100; i++) {
            es1.submit(new NumberPrinterTask(i));
        }

        es2.schedule(new NumberPrinterTask(1), 10, TimeUnit.SECONDS);

        es2.scheduleAtFixedRate(new AddNumbersTask(), 10, 10, TimeUnit.SECONDS);
        es2.scheduleWithFixedDelay(new PrintHelloWorld(), 10, 10, TimeUnit.SECONDS);


        //Single Thread Executor

        for (int i = 0; i < 20; i++) {
            es3.submit(new NumberPrinterTask(i));
        }

    }
}

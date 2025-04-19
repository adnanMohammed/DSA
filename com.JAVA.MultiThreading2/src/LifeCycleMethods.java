import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycleMethods {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.submit(new NumberPrinterTask(i));
        }

        service.shutdown(); //initiates Shutdown

        System.out.println("service.isShutdown()=" + service.isShutdown());//Shutdown has been initiated/started, Threads are shutting down
        List<Runnable> runnable = service.shutdownNow();//Available Tasks in Thread pool will execute and tasks availabe in Queue will be returned to runnable

        service.isTerminated();//returns true if all tasks are completed including tasks in Queue

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

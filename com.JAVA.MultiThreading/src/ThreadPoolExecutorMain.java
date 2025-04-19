import java.util.concurrent.*;

public class ThreadPoolExecutorMain {
    public static void main(String[] args) {
        System.out.println("Main Thread entry point");
        ExecutorService executorService = new ThreadPoolExecutor(
                1, 2, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.DiscardPolicy()
        );
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
        });
        executorService.submit(() -> {
            System.out.println("Executing executor service ");
        });
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            executorService.submit(() -> {
                System.out.println("Executing Task " + taskNumber + " by " + Thread.currentThread().getName());
            });
        }
        System.out.println("Main Thread exit point");
    }
}

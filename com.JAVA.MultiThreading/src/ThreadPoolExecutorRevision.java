import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorRevision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Runnable> bq = new ArrayBlockingQueue(6);
		AtomicInteger at = new AtomicInteger(1);

		ThreadFactory threadFactory = new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub

				Thread t1 = new Thread(r);
				t1.setName("adnan-" + at.getAndIncrement());
				t1.setDaemon(false);
				t1.setPriority(Thread.NORM_PRIORITY);
				System.out.println("created thread=" + t1.getName());
				return t1;
			}
		};

		System.out.println("main thread");
		ThreadPoolExecutor tp = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS, bq, threadFactory,
				new ThreadPoolExecutor.DiscardOldestPolicy());

		for (int i = 0; i < 30; i++) {
			final int taskId = i;
			tp.execute(() -> {
				String threadName = Thread.currentThread().getName();
				System.out.println("Task " + taskId + " is running on " + threadName);
				try {
					Thread.sleep(5000); // simulate work
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					System.err.println("Task " + taskId + " was interrupted");
				}

			});
		}
		tp.shutdown();

		try {
			if (!tp.awaitTermination(60, TimeUnit.SECONDS)) {
				tp.shutdownNow(); // Force shutdown if not terminated
			}
		} catch (InterruptedException e) {
			tp.shutdownNow(); // Re-interrupt current thread
			Thread.currentThread().interrupt();
		}

		System.out.println("Main thread finished.");

	}

}

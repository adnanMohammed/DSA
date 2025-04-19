import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorUtilityFactoryThreadPools {
	public static void main(String[] args) {
		ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(2,Executors.defaultThreadFactory());
		fixedThreadExecutor.execute(() -> {
			System.out.println("executing the 1 service with ThreadName=" + Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("executing the 1 service done with ThreadName=" + Thread.currentThread().getName());
		});

		fixedThreadExecutor.execute(() -> {
			System.out.println("executing the 2 service with ThreadName=" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("executing the 2 service done with ThreadName=" + Thread.currentThread().getName());
		});

		fixedThreadExecutor.execute(() -> {
			System.out.println("executing the 3 service with ThreadName=" + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		fixedThreadExecutor.execute(() -> {
			System.out.println("executing the 4 service with ThreadName=" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		fixedThreadExecutor.execute(() -> {
			System.out.println("executing the service with ThreadName=" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		ExecutorService cachedThreadPoolExecutor = Executors.newCachedThreadPool();
		cachedThreadPoolExecutor.submit(() -> {
			System.out.println("cached Thread Pool Executor");
		});

		ExecutorService singleThreadExecute = Executors.newSingleThreadExecutor();
		singleThreadExecute.submit(() -> {
			System.out.println("Single Thread pool executor");
		});

		fixedThreadExecutor.shutdown();
	}

}

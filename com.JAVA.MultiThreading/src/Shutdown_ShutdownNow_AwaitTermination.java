import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shutdown_ShutdownNow_AwaitTermination {
	public static void main(String[] args) {
		System.out.println("1st line of  main thread");
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.submit(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("In submit method 1 of executor completed and Thread name="+Thread.currentThread().getName());
		});
		executor.shutdown();
		//executor.shutdownNow();
		try {
		boolean isTerminated=	executor.awaitTermination(1, TimeUnit.SECONDS);
		System.out.println("isTerminated="+isTerminated);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	executor.submit(() -> {
			System.out.println("In submit method 2 of executor and Thread name="+Thread.currentThread().getName());
		});*/
		
		System.out.println(" main thread completed succesfully");
		
	}
}

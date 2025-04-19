import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample1 {
	public static void main(String[] args) {
		ThreadPoolExecutor execute = new ThreadPoolExecutor(3, 3, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
				new ThreadPoolExecutor.DiscardPolicy());

		System.out.println("in main method Thread name=" + Thread.currentThread().getName());
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("in completableFuture Thread name=" + Thread.currentThread().getName());

			return "Mohammed";
		}, execute);

		CompletableFuture<String> completableFuture2 = completableFuture.thenApplyAsync((String s) -> {
			System.out.println("in completableFuture2 Thread name=" + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s + " Adnan";
		}, execute);
		
		
		
		
		
		CompletableFuture<String> completableFuture3 = completableFuture2.thenApply((String s) -> {
			System.out.println("in completableFuture3 Thread name=" + Thread.currentThread().getName());

			return s + " is";
		});
		CompletableFuture<String> completableFuture4 = completableFuture3.thenApply((String s) -> {
			System.out.println("in completableFuture4 Thread name=" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s + " very";
		});
		CompletableFuture<String> completableFuture5 = completableFuture4.thenApply((String s) -> {
			System.out.println("in completableFuture5 Thread name=" + Thread.currentThread().getName());

			return s + " good";
		});

		CompletableFuture<String> completableFuture6 = completableFuture5.thenApply((String s) -> {
			System.out.println("in completableFuture6 Thread name=" + Thread.currentThread().getName());

			return s + " Java";
		});
		
		
		
		CompletableFuture result12=completableFuture6.thenAccept((String s)->{
			System.out.println("All the tasks are completed ="+s);
		});
		

		CompletableFuture<String> completableFuture7 = completableFuture.thenCompose((String s) -> {
			System.out.println("in completableFuture7 Thread name=" + Thread.currentThread().getName());

			return completableFuture2;
		});
		try {
			System.out.println("completable future=" + completableFuture6.get() + " with Thread name="
					+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CompletableFuture<?> combinationResult= completableFuture5.thenCombine(completableFuture6, (res1,res2)->res1+","+res2);
		System.out.println("in main method Thread name=" + Thread.currentThread().getName() + " completed");
		
		execute.shutdown();
	}

}

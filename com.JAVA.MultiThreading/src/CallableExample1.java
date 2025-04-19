import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableExample1 {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(4),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
		
		// case 1 with public Future<?> submit(Runnable task) {
				Future<?> futureRunnable = executor.submit(() -> {
					System.out.println( "hello world");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				try {
					Object ans = futureRunnable.get();
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		// case 2 with public <T> Future<T> submit(Callable<T> task) {
		Future<String> futureCallable = executor.submit(() -> {
			return "hello world";
		});
		try {
			String ans = futureCallable.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		// case 3 with  public <T> Future<T> submit(Runnable task, T result) {};
		List<Integer> res = new ArrayList<>();
		res.add(1000);
		res.add(200);
		res.add(300);
		Future<List<Integer>> fut = executor.submit(() -> {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("the thread is being executed");
		}, res);

		try {
			List<Integer> ans = fut.get();
			System.out.println("ans=" + ans);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//or Case 2 and case 3 combined another example
		// public <T> Future<T> submit(Callable<T> task) {
		Future<List<Integer>> future = executor.submit(() -> {
			List<Integer> result = new ArrayList<>();
			res.add(1000);
			res.add(200);
			res.add(300);
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("the thread is being executed");
			return result;
		});

		try {
			List<Integer> ansres = future.get();
			System.out.println("ans=" + ansres);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdown();
	}

}

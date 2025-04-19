import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureExample {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
		Future fut = executor.submit(() -> {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("the thread is being executed");
		});

		try {
			System.out.println("fut.get(1,TimeUnit.SECONDS)=" + fut.get(1, TimeUnit.SECONDS));
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("Timeout happend and dint retreive the data in 1 sec");
			System.out.println(e.getMessage());
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Exception ex");
			System.out.println(ex.getLocalizedMessage());
		}
		fut.cancel(true);
		System.out.println("is cancelled=" + fut.isCancelled());
		System.out.println("is done=" + fut.isDone());

		executor.shutdown();
	}

}

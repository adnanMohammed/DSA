import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
	public static void main(String[] args) {

		ThreadLocal<String> tlocalObj1 = new ThreadLocal<>();
		tlocalObj1.set("main method thread");
		System.out.println("This is the main thread");
		Thread t = new Thread(() -> {
			tlocalObj1.set(" thread t");
			System.out.println("In thread t");
		});
		t.start();
		String ans = tlocalObj1.get();
		System.out.println("ans=" + ans);
		tlocalObj1.remove();
		System.out.println("ans of tlocal=" + tlocalObj1.toString());

		System.out.println("main thread has been completed");
//-----------------------------------------------------------------------------------------------------------------------------//
		ThreadLocal<String> tlocalObj = new ThreadLocal<>();
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(() -> {
			tlocalObj.set("Thread1");
			tlocalObj.remove();
		});

		for (int i = 0; i < 10; i++) {
			service.submit(() -> {
				System.out.println("Thread name=" + tlocalObj.get());
			});
		}

	}
}

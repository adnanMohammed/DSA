import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	Semaphore semaphore = new Semaphore(2);

	public void task() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " enter into taks()");
			System.out.println(Thread.currentThread().getName() + " enter into taks() executing");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		finally {
			semaphore.release();
		}
		System.out.println(Thread.currentThread().getName() + " exits from task()");
	}
}

class SemaphoreExampleMain {
	public static void main(String[] args) {
		SemaphoreExample ex = new SemaphoreExample();

		Thread thread1 = new Thread(() -> {
			ex.task();
		}, "Thread1");
		Thread thread2 = new Thread(() -> {
			ex.task();
		}, "Thread2");
		Thread thread3 = new Thread(() -> {
			ex.task();
		}, "Thread3");
		Thread thread4 = new Thread(() -> {
			ex.task();
		}, "Thread4");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

	}
}

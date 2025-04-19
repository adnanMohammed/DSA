import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	ReentrantLock reentLock = new ReentrantLock(true);
	
	public static int COUNTER = 0;

	public void increment() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " enters into increment()");
		try {
			reentLock.lock();
			System.out.println(Thread.currentThread().getName()
					+ " in increment() counter has been locked and counter is " + COUNTER);
			COUNTER++;
			System.out.println(
					Thread.currentThread().getName() + " in increment() counter has been increased to " + COUNTER);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reentLock.unlock();
			System.out.println(Thread.currentThread().getName()
					+ " in increment() finally counter has been unlocked and counter is " + COUNTER);
		}

	}

}

class ReentrantLockExampleMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Entered into the main Thread " + Thread.currentThread().getName());
		ReentrantLockExample sharedResouce1 = new ReentrantLockExample();
		ReentrantLockExample sharedResouce2 = new ReentrantLockExample();
		ReentrantLockExample sharedResouce3 = new ReentrantLockExample();
		Thread Thread1 = new Thread(() -> {
			System.out.println("Thread1 has been created");
			sharedResouce1.increment();
		}, "Thread1");
		Thread Thread2 = new Thread(() -> {
			System.out.println("Thread2 has been created");
			sharedResouce2.increment();
		}, "Thread2");
		Thread Thread3 = new Thread(() -> {
			System.out.println("Thread3 has been created");
			sharedResouce3.increment();
		}, "Thread3");
		System.out.println("before start() in main Thread " + Thread.currentThread().getName());
		Thread1.start();
		Thread.sleep(2000);
		Thread2.start();
		Thread.sleep(2000);
		Thread3.start();
		System.out.println("Exiting from the main Thread " + Thread.currentThread().getName());
	}
}
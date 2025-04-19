import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReadWriteLockExample {

	ReadWriteLock rwLock = new ReentrantReadWriteLock(true);
	ReentrantReadWriteLock.WriteLock writeLock = (WriteLock) rwLock.writeLock();
	ReentrantReadWriteLock.ReadLock readLock = (ReadLock) rwLock.readLock();
	public static int COUNTER = 0;

	public void incrementWrite() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " enters into incrementWrite()");
		try {
			writeLock.lock();
			System.out.println(
					Thread.currentThread().getName() + " incrementWrite() has been locked and counter is " + COUNTER);
			COUNTER++;
			System.out.println(
					Thread.currentThread().getName() + " in incrementWrite() counter has been increased to " + COUNTER);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
			System.out.println(Thread.currentThread().getName()
					+ " in incrementWrite() finally counter has been unlocked and counter is " + COUNTER);
		}

	}

	public void incrementRead() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " enters into increment()");
		try {
			readLock.lock();
			System.out.println(Thread.currentThread().getName()
					+ " in incrementRead() counter has been locked and counter is " + COUNTER);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
			System.out.println(Thread.currentThread().getName()
					+ " in incrementRead() finally counter has been unlocked and counter is " + COUNTER);
		}

	}

}

class ReadWriteLockExampleMain {
	public static void main(String[] args) throws Exception {
		ReadWriteLockExample readwrite1 = new ReadWriteLockExample();
		ReadWriteLockExample readwrite2 = new ReadWriteLockExample();
		ReadWriteLockExample readwrite3 = new ReadWriteLockExample();
		Thread Thread1 = new Thread(() -> {
			System.out.println("Thread1 has been created");
			readwrite1.incrementWrite();
		}, "Thread1");
		Thread Thread2 = new Thread(() -> {
			System.out.println("Thread2 has been created");
			readwrite2.incrementWrite();
		}, "Thread2");
		Thread Thread3 = new Thread(() -> {
			System.out.println("Thread3 has been created");
			readwrite3.incrementRead();
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

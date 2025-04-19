import java.util.concurrent.locks.StampedLock;

public class StampedLock_optimistic {
	StampedLock stampLock = new StampedLock();
	public static int COUNTER = 0;

	public void incrementwrite() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " enters into incrementwrite()");
		long writeStamp = stampLock.writeLock();
		try {
			System.out.println(Thread.currentThread().getName()
					+ " in incrementwrite() counter has been locked and counter is " + COUNTER);
			COUNTER++;
			System.out.println(
					Thread.currentThread().getName() + " in incrementwrite() counter has been increased to " + COUNTER);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			stampLock.unlockWrite(writeStamp);
			System.out.println(Thread.currentThread().getName()
					+ " in incrementwrite() finally counter has been unlocked and counter is " + COUNTER);
		}

	}

	public void incrementread() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " enters into incrementread()");
		long optimisticReadStamp = stampLock.tryOptimisticRead();
		System.out.println(Thread.currentThread().getName() + " stampLock.tryOptimisticRead() "+stampLock.tryOptimisticRead());
		// Validate if no write has occurred since obtaining the stamp
		System.out.println(
				"does Thread " + Thread.currentThread().getName() + " has aquired writeLock " + stampLock.writeLock());
		if (!stampLock.validate(optimisticReadStamp)) {
			optimisticReadStamp = stampLock.readLock();
			try {
				System.out.println(Thread.currentThread().getName()
						+ " in incrementread() counter has been locked and counter is " + COUNTER);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				stampLock.unlock(optimisticReadStamp);
				System.out.println(Thread.currentThread().getName()
						+ " in incrementread() finally counter has been unlocked and counter is " + COUNTER);
			}

		}
	}
}

class StampedLock_optimisticMain {
	public static void main(String[] args) throws Exception {
		StampedLock_optimistic stampedLock1 = new StampedLock_optimistic();
		StampedLock_optimistic stampedLock2 = new StampedLock_optimistic();
		StampedLock_optimistic stampedLock3 = new StampedLock_optimistic();
		Thread Thread1 = new Thread(() -> {
			System.out.println("Thread1 has been created");
			stampedLock1.incrementwrite();
		}, "Thread1");
		Thread Thread2 = new Thread(() -> {
			System.out.println("Thread2 has been created");
			stampedLock2.incrementwrite();
		}, "Thread2");
		Thread Thread3 = new Thread(() -> {
			System.out.println("Thread3 has been created");
			stampedLock3.incrementread();
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

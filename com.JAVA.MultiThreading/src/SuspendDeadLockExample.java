public class SuspendDeadLockExample {
	boolean isItemAvailable = false;

	public synchronized void produce() {
		System.out.println(Thread.currentThread().getName() + " has entered to add item and lock is aquired");
		// if item is already available, the producer should not produce the item
		isItemAvailable = true;
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " lock released");
	}
}

class SuspendDeadLockMain {
	public static void main(String[] args) {
		System.out.println(" main method Thread started ");
		SuspendDeadLockExample sp = new SuspendDeadLockExample();
		Thread th1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " has been started");
			sp.produce();
	
		}, "th1");
		Thread th2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " has been started");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sp.produce();
		}, "th2");
		th1.start();
	
		th2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread th1 is suspended ");
		th1.suspend();
		System.out.println("Thread th1 is resumed ");
		th1.resume();
		System.out.println("main Thread is finished ");
		
	}
}

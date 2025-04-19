import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
	
	AtomicInteger atomicInt=new AtomicInteger();

	

	public void increment() {
	
		System.out.println(Thread.currentThread().getName()+" counter value="+atomicInt.incrementAndGet());
	}

}

class AtomicExampleMain {
	public static void main(String[] args) {
		AtomicExample ex = new AtomicExample();
		Thread Thread1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				ex.increment();
			}
		}, "Thread1");
		Thread Thread2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				try {
					Thread1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ex.increment();
			}
		}, "Thread2");
		Thread1.start();
		Thread2.start();
		try {
			Thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The value of counter=" + ex.atomicInt.get());
	}
}
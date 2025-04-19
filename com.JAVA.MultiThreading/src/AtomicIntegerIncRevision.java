import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerIncRevision {

	AtomicInteger at = new AtomicInteger(0);

	public void incCount() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ", in incCount()="+at.incrementAndGet());
	}

	public int getCount() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return at.get();
	}
}

class AtomicIntegerIncRevisionMain {
	public static void main(String[] args) {
		AtomicIntegerIncRevision i = new AtomicIntegerIncRevision();

		for (int j = 1; j <= 10; j++) {
			Thread t1 = new Thread(() -> {
				i.incCount();
				
			}, "t" + j);
			t1.start();
		}

		for (int j = 1; j <= 5; j++) {
			Thread t1 = new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + ", count=" + i.getCount());
			
			}, "c" + j);
			t1.start();
		}
	}
}
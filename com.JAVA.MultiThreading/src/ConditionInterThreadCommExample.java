import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionInterThreadCommExample {
	Queue<Integer> q = new LinkedList<>();
	ReentrantLock reentrantLock = new ReentrantLock(true);
	Condition conditonLock = reentrantLock.newCondition();
	int count = 1;

	public void insertToQ() {
		System.out.println(Thread.currentThread().getName() + " in insertToQ()");
		try {
			reentrantLock.lock();
			System.out.println(Thread.currentThread().getName() + " in insertToQ() locked");
			while (q.size() >= 5) {
				System.out.println(
						Thread.currentThread().getName() + " in insertToQ() locked waiting and q size=" + q.size());
				conditonLock.await();
			}

			q.add(count++);
			System.out.println(Thread.currentThread().getName() + " in insertToQ() locked inc count to " + count
					+ " and q size=" + q.size());
			conditonLock.signalAll();
			
			
		}catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }  finally {
			reentrantLock.unlock();
			System.out.println(Thread.currentThread().getName() + " in insertToQ() in finally block unlocking");
		}
	}

	public void removeFromQ() {
		System.out.println(Thread.currentThread().getName() + " in removeFromQ()");
		try {
			reentrantLock.lock();
			System.out.println(Thread.currentThread().getName() + " in removeFromQ() locked");
			while (q.isEmpty()) {
				System.out.println(Thread.currentThread().getName() + " in removeFromQ() locked waiting as q is empty");
				conditonLock.await();
				
			}

			System.out.println(
					Thread.currentThread().getName() + " in removeFromQ() locked removed an element " + q.poll());
			conditonLock.signalAll();
		}catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }  finally {
			reentrantLock.unlock();
			System.out.println(Thread.currentThread().getName() + " in removeFromQ() finally block unlocked");
		}
	}
}

class ConditionInterThreadCommExampleMain {
	public static void main(String[] args) {
		ConditionInterThreadCommExample ex = new ConditionInterThreadCommExample();

		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(() -> {
				ex.insertToQ();
			}, "Threadinsert" + i);
			t1.start();
			
		}
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread(() -> {
				ex.removeFromQ();
			}, "Threadremove" + i);
			t1.start();
		
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
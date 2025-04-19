import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerRevisionQueue {
	Queue<Integer> q = new LinkedList<>();

	public synchronized void addItems(int i) {
		while (q.size() >= 5) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(i+", producing.....");
		q.add(i);
		notifyAll();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void removeItems() {
		while (q.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(q.peek()+", consuming.....");
		q.remove();
		notifyAll();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ProducerConsumerRevisionQueueMain {
	public static void main(String[] args) {
		ProducerConsumerRevisionQueue pc = new ProducerConsumerRevisionQueue();
		Thread producer = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				pc.addItems(i);
			}
		}, "producer");
		Thread consumer = new Thread(() -> {
			for (int j = 0; j < 10; j++) {
				pc.removeItems();
			}
		}, "consumer");
		producer.start();
		
		consumer.start();
	}
}

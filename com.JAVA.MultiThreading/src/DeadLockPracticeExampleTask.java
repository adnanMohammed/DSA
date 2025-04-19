
public class DeadLockPracticeExampleTask {
	
	int counter=0;
	
	public synchronized void incrementCounter() {
		counter++;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class DeadLockPracMain{
	public static void main(String[] args) {
		DeadLockPracticeExampleTask ex=new DeadLockPracticeExampleTask();
		System.out.println("In main method main thread ");
		Thread t1=new Thread(()->{
			System.out.println("In Thread t1 before incrementCounter()");
			synchronized (ex) {
				try {
					System.out.println("Thread t1 waiting to get notified");
					ex.wait();
					System.out.println("Thread t1 is notified");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ex.incrementCounter();
				ex.notify();
			}
			
		},"t1");
		
		Thread t2=new Thread(()->{
			System.out.println("In Thread t2 before incrementCounter()");
			synchronized (ex) {
				try {
					System.out.println("Thread t2 waiting to get notified");
					ex.wait();
					System.out.println("Thread t2 is notified");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ex.incrementCounter();
				ex.notify();
				
			}
			
		},"t2");
		t1.start();
		t2.start();
		System.out.println("In main method main thread completed ");
		
	}
}

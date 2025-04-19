public class DeadLock {
    //This is a deadlock situation.
    //t1 has lock lock1, t2 has lock lock2,
    //t1 is waiting for lock2 to be released,
    // t2 is waiting for lock1 to be released. This is deadlock situation
    //to avoid deadlock situation put locks in same order
    public static void main(String[] args) {
        System.out.println("In main method start");
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println("t1 9");
            synchronized (lock1) {
                System.out.println("t1 11");
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread t1 state"+   Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("lock acquired");
                }
            }
        }, "Thread t1");
        System.out.println("In main method mid");
        Thread t2 = new Thread(() -> {
            System.out.println("t2 19");

            synchronized (lock2) {
                System.out.println("t2 21");
                try {
                    Thread.sleep(1000);
                    System.out.println( "Thread t2 state="+  Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("lock acquired");
                }
            }
        }, "Thread t2");
        t1.start();
        t2.start();
        System.out.println("In main method end");
    }
}

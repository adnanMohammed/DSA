

public class QueueMain {
    public static void main(String[] args) {
        System.out.println("In main method thread start");
        Thread t1 = new Thread(() -> {
            QueueImpl q = new QueueImpl(5);
            for (int i = 0; i < 5; i++) {
                System.out.println("In loop thread t1" + Thread.currentThread());
                q.add(i);
            }
        }, "Thread t1");

        System.out.println("In main method thread t1");
        System.out.println("Thread t1 state=" + t1.getState());
        Thread t2 = new Thread(() -> {
            QueueImpl q = new QueueImpl(5);
            for (int i = 0; i < 5; i++) {
                System.out.println("In loop thread t2");
                q.remove();
            }
        }, "Thread t2");
        System.out.println("In main method thread t2");
        System.out.println("Thread t2 state=" + t2.getState());
        Thread t3 = new Thread(() -> {
            QueueImpl q = new QueueImpl(5);
            for (int i = 0; i < 5; i++) {
                System.out.println("In loop thread t3");
                q.remove();
            }
        }, "Thread t3");
        System.out.println("Thread t2 state=" + t2.getState());
        System.out.println("In main method thread t3");
        Thread t4 = new Thread(() -> {
            QueueImpl q = new QueueImpl(5);
            for (int i = 0; i < 5; i++) {
                System.out.println("In loop thread t4");
                q.add(i);
            }
        }, "Thread t4");
        System.out.println("Thread t4 state=" + t4.getState());
        System.out.println("In main method thread t4");
        Thread t5 = new Thread(() -> {
            QueueImpl q = new QueueImpl(5);
            for (int i = 0; i < 5; i++) {
                System.out.println("In loop thread t5");
                q.remove();
            }
        }, "Thread t5");
        System.out.println("In main method thread t5");
        System.out.println("Thread t3 state=" + t3.getState());
        System.out.println("Thread t5 state=" + t5.getState());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        System.out.println("In main method thread end");

    }
}

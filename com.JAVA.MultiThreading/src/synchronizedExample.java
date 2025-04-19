public class synchronizedExample {
    static int i=1;
    public static void main(String[] args) {
        String LOCK="lock";
        System.out.println(Thread.currentThread().getName()+"4 main thread="+i);
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName() + " increment");
                i = i + 1;
                System.out.println(Thread.currentThread().getName() + " increment=" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println(Thread.currentThread().getName() + " decrement");
                i = i - 1;
                System.out.println(Thread.currentThread().getName() + " decrement=" + i);
            }
        });
        t1.start();
        t2.start();

        System.out.println(Thread.currentThread().getName()+"14 main thread="+i);

    }
}

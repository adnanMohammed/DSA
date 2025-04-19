public class JavaThreadInterrupts {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t1.interrupt();

        Thread t2 = new Thread(() -> {
            System.out.println("start to wait");
            System.out.println("Hello World");

            System.out.println("done to wait");
        });
        t2.start();

        t2.interrupt();//requests the Thread t2 to interrupt and stop execution
        System.out.println("12 Is t2 Interrupted="+t2.isInterrupted());//checks if Thread t2 is interrupted
        System.out.println("13 Is t2 Interrupted="+Thread.interrupted());//checks if Thread's interrupted flag=true and if true changes the flag to false
        System.out.println("14 Is t2 Interrupted="+t2.isInterrupted());//checks if Thread t2 is interrupted

    }
}

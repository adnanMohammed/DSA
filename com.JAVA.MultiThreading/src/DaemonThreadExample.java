public class DaemonThreadExample {
    public static void main(String[] args) {
       // System.out.println(Thread.currentThread().getName() + " is a main Thread");
        Thread DaemonThread = new Thread(
                () -> {
                   // System.out.println("before ");
                    if (Thread.currentThread().isDaemon()) {
                        System.out.println( " is a Daemon Thread");

                        System.out.println("if DaemonThread.getPriority()="+Thread.currentThread().getPriority());

                    }
                    else {
                        System.out.println(" is not a Daemon Thread");
                        System.out.println("else  DaemonThread.getPriority()="+Thread.currentThread().getPriority());
                    }
                });
        DaemonThread.setDaemon(true);//make sure to set Daemon before start();
        DaemonThread.start();


        DaemonThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("17 DaemonThread.getPriority()="+DaemonThread.getPriority());
    }
}

public class SynchronizationIssues {
     static int value=1;
    public static  void main(String[] args) {
        System.out.println("In main thread");
        Thread t1=new Thread(()->{

            System.out.println("In t1 thread="+value);
            value++;
            System.out.println("In t1 thread="+value);
        });
        System.out.println("In main thread");
        Thread t2=new Thread(()->{
            System.out.println("In t2 thread="+value);
            value++;
            System.out.println("In t1 thread="+value);
        });
        System.out.println("In main thread");
        t1.start();
        System.out.println("In main thread");
        t2.start();
        System.out.println("In main thread");
    }
}

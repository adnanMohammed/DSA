public class ThreadMain {

    public static void main(String[] args) {
        System.out.println("in main method first line");
        //implements runnable
        Thread t=new Thread(new Thread1(),"Thread1");
        t.start();
        System.out.println("in main method running");
        //extends Thread
        Thread2 t1=new Thread2();
        t1.start();
        //extends Thread(passing Thread extended class in arguments)
        Thread t3=new Thread(new Thread3(),"Thread3");
        t3.start();
        System.out.println("in main method completed");
        Thread t4=new Thread(()->{
            for (int i = 1; i < 10; i++) {
                System.out.println("t4="+Thread.currentThread()+"i="+i);
            }
        },"Thread4");
    }
}

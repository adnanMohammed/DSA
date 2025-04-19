public class PrintHelloWorld implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello World in "+this.getClass()+" task t3 and Thread="+Thread.currentThread().getName());
    }
}

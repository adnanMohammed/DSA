public class NumberPrinterTask implements Runnable {

    private int num;

    public NumberPrinterTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("In run method of " + this.getClass() + " with number=" + num + " and Thread name=" + Thread.currentThread().getName());

    }
}

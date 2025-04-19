public class SynchBankAppTaskMainMethod {

    static int balance = 1000;
    static String lock = "LOCK";

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " I am main Thread and balance=" + balance);
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " I am crediting 2000");
                int amount = balance + 2000;
                balance = amount;
                System.out.println(Thread.currentThread().getName() + " The account balance after crediting 2000=" + balance);
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " I am withdrawing 500");
                int amount = balance - 500;
                balance = amount;
                System.out.println(Thread.currentThread().getName() + " The account balance after withdrawing 500=" + balance);
            }
        });
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + " I am main Thread and balance=" + balance);
    }
}

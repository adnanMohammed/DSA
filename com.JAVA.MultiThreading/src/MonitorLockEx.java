public class MonitorLockEx {

    public synchronized void getData() {
        try {
            System.out.println("in synchronized block of getData before sleep");
            Thread.sleep(10000);

            System.out.println("in synchronized block of getData after sleep");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDatasyncBlock() {
        System.out.println("in synchronized block of getDatasyncBlock before synchronized block");
        try {
            synchronized (this) {
                System.out.println("in synchronized block of getDatasyncBlock");
                int i = 10, j = 5;
                int ans = i / j;
                System.out.println(" the ans is=" + ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add2num(int i, int j) {
        System.out.println("adding 2 num " + i + " and " + j);
    }
}

class mainMethod1 {
    public static void main(String[] args) {
        MonitorLockEx ex = new MonitorLockEx();
        MonitorLockEx ex1 = new MonitorLockEx();
        Thread t1 = new Thread(() -> {
            ex.getData();
        });

        Thread t2 = new Thread(() -> {
            ex1.getDatasyncBlock();
        });

        Thread t3 = new Thread(() -> {
            ex.add2num(1, 2);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

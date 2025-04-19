public class Thread3 extends Thread {

    @Override
    public void run() {
        for (int i = 100; i < 110; i++) {
            System.out.println("In Thread3=" + i);
        }
    }
}

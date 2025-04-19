import java.util.Collection;

public class Thread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("In Thread1=" + Thread.currentThread() + " i=" + i);
        }

    }
}


public class AddNumbersTask extends Thread {
    int i = 10, j = 20;

    @Override
    public void run() {

        int k = i + j;
        System.out.println("overriding run method and after adding=" + k + " and current thread name =" + Thread.currentThread().getName());
    }
}

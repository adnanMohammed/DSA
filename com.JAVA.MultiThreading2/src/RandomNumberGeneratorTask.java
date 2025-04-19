import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumberGeneratorTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        Random random = new Random();
        return random.nextInt(10);
    }
}

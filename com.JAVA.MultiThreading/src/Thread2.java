import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Thread2 extends Thread {
    @Override
    public void run() {
        List<String> s = Arrays.asList("faisal", "nasir", "adnan", "nusrath", "abrar", "pasha", "syed");
        for (int i = 0; i < s.size(); i++) {
            System.out.println("In Thread2=" + s.get(i));
        }
    }
}

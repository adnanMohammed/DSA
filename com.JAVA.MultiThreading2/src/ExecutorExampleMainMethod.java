import java.net.http.HttpClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExampleMainMethod {

    public static void main(String[] args) {
        System.out.println("In main Thread=" + Thread.currentThread().getName());
        //No Suitable to create 1000 new threads because more memory comsumption
        /*for (int i = 0; i < 1000 ; i++) {
            new Thread(new NumberPrinterTask(i)).start();
        }*/
        int coreCount=Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available processors: coreCount="+coreCount);
        //create a Pool
        ExecutorService es = Executors.newFixedThreadPool(coreCount);
        for (int i = 0; i < 1000; i++) {
            //submit each task at a time for execution
            //Executor Framework maintains a blocking Queue where all the Tasks are stored,and each at a time
            //is assigned to Thread
            es.submit(new NumberPrinterTask(i));
        }
        System.out.println("In main Thread=" + Thread.currentThread().getName());
    }
}

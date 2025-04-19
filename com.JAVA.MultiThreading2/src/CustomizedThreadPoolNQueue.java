import java.util.concurrent.*;

public class CustomizedThreadPoolNQueue {

    public static void main(String[] args) {
        ExecutorService es=new ThreadPoolExecutor(2, 2,
                100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4));
      try{
          es.submit(new NumberPrinterTask(1));
      }
      catch (RejectedExecutionException ex){
          System.out.println("adnan");
            ex.printStackTrace();
      }


    }
}

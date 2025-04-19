import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        /*List<Future<Integer>> addFutureData=new ArrayList<Future<Integer>>();
        for (int i = 0; i <100 ; i++) {
          Future<Integer> result=  service.submit(new RandomNumberGeneratorTask());
          addFutureData.add(result);
        }

        for (Future<Integer> data:addFutureData) {
            data.get(10, TimeUnit.SECONDS);
            //returns true if task was cancelled
            data.isCancelled();
            //cancels the task
            data.cancel(false);
            //returns true if the task is completed(succesfull/otherwise)
            data.isDone();
            System.out.println("the result for data="+ data.get());
        }*/

        Future<Integer> result = service.submit(new RandomNumberGeneratorTask());

      //  result.get(1, TimeUnit.NANOSECONDS);
        System.out.println("result.isDone()="+  result.isDone());
       System.out.println("result.isCancelled()="+ result.isCancelled());
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}

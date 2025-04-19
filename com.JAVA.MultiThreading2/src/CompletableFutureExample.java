import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExample {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->new AddNumbersTask()).
                thenApply(value->new RandomNumberGeneratorTask()).
                thenApplyAsync(value -> new RandomNumberGeneratorTask(), Executors.newSingleThreadExecutor()).
                exceptionally(failed->new RandomNumberGeneratorTask()).
                thenAccept(val-> new RandomNumberGeneratorTask());

      /*  Future<String> a1= CompletableFuture.supplyAsync(()->{
            return "Adnan";
        }).thenApply((order)->{return "adnn";}).thenApplyAsync((v)->{
         return "5";
        },Executors.newSingleThreadExecutor()).thenAccept();


*/



       CompletableFuture<Integer> value= CompletableFuture.supplyAsync(()->{
            Future<Integer> future= (Future<Integer>) new RandomNumberGeneratorTask();
            int res;
           try {
            res=   future.get();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           } catch (ExecutionException e) {
               throw new RuntimeException(e);
           }
            return res;
       });
    }
}

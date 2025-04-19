import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableRevision {
	public static void main(String[] args) {
			ExecutorService exe=new ThreadPoolExecutor(2, 5, 2, TimeUnit.SECONDS,new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
			Future<Integer> res=exe.submit(()-> {
				Thread.sleep(5000);
				return 10;
			});
			res.cancel(true);
			System.out.println("isCanceled="+ res.isCancelled());
			try {
				int i1=res.get(1, TimeUnit.MILLISECONDS);
				int i=res.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(exe.isShutdown())
				exe.shutdown();
	}
}

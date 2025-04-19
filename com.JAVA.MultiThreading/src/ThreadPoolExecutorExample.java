import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



class CustomThreadyFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(r);
		thread.setDaemon(false);
		thread.setName("Thread1");
		thread.setPriority(Thread.NORM_PRIORITY);
		return thread;
	}

}

class CustomRejectExecutionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.println("The Task has been rejected=" + r.toString());
		
	}

}

public class ThreadPoolExecutorExample {
	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
				new CustomThreadyFactory(), new CustomRejectExecutionHandler());
		//executor.allowCoreThreadTimeOut(true);
	
		
		for (int i = 0; i < 10; i++) {
		
			executor.submit(()->{
				System.out.println("Executing the task");
			});
		}
		
		executor.shutdown();
	}
}

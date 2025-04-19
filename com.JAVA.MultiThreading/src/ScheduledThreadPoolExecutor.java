import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutor {
	public static void main(String[] args) {
		/*ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		service.schedule(() -> {
			System.out.println("My name is Adnan");
		}, 2, TimeUnit.SECONDS);
		
		Future<String> ans=service.schedule(() -> {
			return "My name is Adnan";
		}, 10, TimeUnit.SECONDS);
		try {
			System.out.println("ans="+ans.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();*/
	System.out.println("In main method before 	ScheduledExecutorService execService=	Executors.newScheduledThreadPool(1);");	
	/*ScheduledExecutorService execService= new java.util.concurrent.ScheduledThreadPoolExecutor(5);
	Future<?> future=execService.scheduleAtFixedRate(()->{
		System.out.println("execService scheduleAtFixedRate()");
	},1 , 3, TimeUnit.SECONDS);
	try {
		Thread.sleep(10000);
		future.cancel(true);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	execService.shutdown();
	System.out.println("after shutdown");*/
	
	ScheduledExecutorService exec=Executors.newScheduledThreadPool(5);
	ScheduledFuture fut=exec.scheduleWithFixedDelay(()->{
		System.out.println("scheduled with fixed delay");
	}, 2, 5, TimeUnit.SECONDS);
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	fut.cancel(true);
	exec.shutdown();
	System.out.println("main method last line");
	}
}

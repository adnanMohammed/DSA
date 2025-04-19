import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExample {
	public static void main(String[] args) {
		/**
		 * Java Virtual Threads are a feature introduced in Project Loom, aiming to
		 * simplify the development of concurrent applications in Java. They were
		 * officially added in JDK 21 as part of the Java standard. Threads are
		 * lightweight threads that provide a more scalable and efficient alternative to
		 * traditional platform threads, enabling applications to handle a large number
		 * of concurrent tasks with minimal overhead.
		 */	
		
	
	//ExecutorService ex=	Executors.newVirtualThreadPerTaskExecutor();
	
	Runnable run1=()->{
		System.out.println("adnan");
	};
	Thread.ofVirtual().start(run1);
	}
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolRevision1 {

	public static void main(String[] args) {
		/*
		 * ExecutorService es = Executors.newFixedThreadPool(5); AtomicInteger ai = new
		 * AtomicInteger(1); for (int i = 0; i < 40; i++) { es.submit(() -> {
		 * System.out.println( "In es submit, count=" + ai.getAndIncrement() + ", name="
		 * + Thread.currentThread().getName()); }); }
		 */

		/*
		 * ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
		 * AtomicInteger aic = new AtomicInteger(1); for (int i = 0; i < 40; i++) {
		 * cacheThreadPool.submit(() -> { try { Thread.sleep(5000); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println( "In es submit, count=" +
		 * aic.getAndIncrement() + ", name=" + Thread.currentThread().getName()); }); }
		 */

		/*
		 * ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
		 * AtomicInteger sic = new AtomicInteger(1); for (int i = 0; i < 40; i++) {
		 * singleThreadPool.submit(() -> { try { //Thread.sleep(5000); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println( "In es submit, count=" + sic.getAndIncrement() +
		 * ", name=" + Thread.currentThread().getName()); }); }
		 */

		/*
		 * ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
		 * AtomicInteger sic = new AtomicInteger(1); for (int i = 0; i < 40; i++) {
		 * scheduledThreadPool.submit(() -> { try { // Thread.sleep(5000); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println( "In es submit, count=" + sic.getAndIncrement() +
		 * ", name=" + Thread.currentThread().getName()); }); }
		 */

		// scheduler.schedule(() -> System.out.println("Runs after 3 sec"), 3,
		// TimeUnit.SECONDS);
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

		scheduler.scheduleWithFixedDelay(() -> {
			System.out.println(Thread.currentThread().getName() + " START at " + java.time.LocalTime.now());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " END   at " + java.time.LocalTime.now());
		}, 1, 3, TimeUnit.SECONDS);

		// scheduler.scheduleWithFixedDelay(() -> System.out.println("Fixed delay"), 1,
		// 20, TimeUnit.SECONDS);

		ExecutorService es = Executors.newWorkStealingPool();
		
	}

}

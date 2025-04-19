
public class VolatileExample {
	static boolean flag = false;

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			System.out.println("Inside " + Thread.currentThread().getName());
			VolatileExample.flag = true;
			System.out.println("In "+ Thread.currentThread().getName()+" flag=" + flag);
		}, "t1");
		Thread t2 = new Thread(() -> {
			System.out.println("Inside " + Thread.currentThread().getName());
			System.out.println("In "+ Thread.currentThread().getName()+" flag=" + flag);
			
			while (flag) {
				System.out.println("Inside while");
				flag = false;

			}
			System.out.println("outside while");

		}, "t2");
		System.out.println("main method");
		t1.start();
		t2.start();
	}
}

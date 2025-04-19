public class Visibility_Volatile_Example {

  //  private static  boolean flag = false; //Visibility issue
    private static volatile boolean flag = false; //Visibility issue fixed

    public static void main(String[] args) {
        // Start two threads
        Thread thread1 = new Thread(() -> {
            // Thread 1 modifies the shared variable
            flag = true;
            System.out.println("Thread 1: Set flag to true");
        });

        Thread thread2 = new Thread(() -> {
            // Thread 2 accesses the shared variable
            while (!flag) {
                // Wait until the flag becomes true
                System.out.println("Wait until the flag becomes true");
            }
            System.out.println("Thread 2: Flag is now true");
        });

        // Start the threads

        thread2.start();
        thread1.start();
    }
}

public class StackImplMain {

    public static void main(String[] args) {
        System.out.println("This is main Thread");
        int capacity=5;
        StackImp s=new StackImp(capacity);
        Thread t=new Thread(()->{
            for (int i = 0; i <capacity ; i++) {
            System.out.println(i+" In Thread t="+s.push(i));
            }
        },"stackImpl");
        t.start();

        Thread t1=new Thread(()->{
            for (int i = 0; i <capacity; i++) {
                System.out.println(i+" In Thread t1="+s.pop());
            }
        });
        t1.start();
        System.out.println("This is main Thread");
    }
}

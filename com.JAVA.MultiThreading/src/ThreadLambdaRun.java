import javax.sound.midi.Soundbank;

public class ThreadLambdaRun {

    public static void main(String[] args) {
        Thread t1=new Thread(()->{

            for (int i = 0; i <5 ; i++) {
                System.out.println("In Thread t1="+i);
            }
        },"Thread t1");
        System.out.println("Thread t1.state="+ t1.getState());
        Thread t2=new Thread(()->{
            System.out.println("Thread t1.state in t2="+ t1.getState());
            for (int i = 0; i <5 ; i++) {
                System.out.println("In Thread t2="+i);
            }
        },"Thread t2");
        Thread t3=new Thread(()->{
            System.out.println("In Thread t3");
        },"Thread t3");
        Thread t4=new Thread(()->{
            System.out.println("Thread t1.state in t4="+ t1.getState());
            for (int i = 0; i <5 ; i++) {
                System.out.println("In Thread t4="+i);
            }
        },"Thread t4");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Thread t1.state in main="+ t1.getState());

        t4.start();

    }
}

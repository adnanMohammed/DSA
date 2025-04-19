public class MainThread {

    public static void main(String[] args) {
        System.out.println("In main method="+Thread.currentThread().getName());
        PrintHelloWorld printHelloWorld=new PrintHelloWorld();
        Thread t1=new Thread(printHelloWorld);
        t1.start();
        System.out.println("In main method="+Thread.currentThread().getName());
        for (int i = 0; i <100 ; i++) {
            NumberPrinterTask numberPrinterTask=new NumberPrinterTask(i);
            Thread numPrintTaskThread=new Thread(numberPrinterTask);
            numPrintTaskThread.start();
        }

        Thread lambdaThread= new Thread(()->{
            System.out.println("I am a lamda man="+Thread.currentThread().getName());
        });
        lambdaThread.start();

        AddNumbersTask addNumbersTask=new AddNumbersTask();
        addNumbersTask.start();

    }
}

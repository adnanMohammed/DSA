import java.util.concurrent.atomic.AtomicReference;

public class SingleTonDesign {
    private volatile static SingleTonDesign s=null;
    private SingleTonDesign(){

    }

    public static synchronized SingleTonDesign createInstance(){
        if (s==null){
            s=new SingleTonDesign();
        }
        return s;
    }
}


class Main{
    public static void main(String[] args) {
        SingleTonDesign s1=SingleTonDesign.createInstance();
        SingleTonDesign s2=SingleTonDesign.createInstance();
        SingleTonDesign s3=SingleTonDesign.createInstance();
        SingleTonDesign s4                                                                                                                                                                                              =SingleTonDesign.createInstance();
    }
}
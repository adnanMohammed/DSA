public class Singleton {
    static Singleton single = null;

    private Singleton() {

    }


    public static Singleton getInstance() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }


    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        Singleton s4 = Singleton.getInstance();
        Singleton s5 = Singleton.getInstance();
    }
}

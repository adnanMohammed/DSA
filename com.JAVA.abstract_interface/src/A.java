public interface A {
    int i=10;
    void eat();
    void sleep();

    default void dance(){
        System.out.println("I am dancing");
    }

    public static void playing() {
        System.out.println("i am sleeping");
    }
}

public class AB implements A,B{
    @Override
    public void eat() {
        System.out.println("i am eating");
    }

    @Override
    public void code() {
        System.out.println("coding ");
    }

    @Override
    public void b1() {
        System.out.println("B1");
    }

    @Override
    public void sleep() {
        System.out.println("i am sleeping");
    }

    public  void testing() {
        System.out.println("i am testing");
    }
    public static void playing() {
        System.out.println("AB Playing static method");
    }

}

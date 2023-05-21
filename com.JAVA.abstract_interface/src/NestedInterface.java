public class NestedInterface {

    public interface A{
        void dance();
    }
}

class A1 implements NestedInterface.A{

    @Override
    public void dance() {
        System.out.println("I am dancing");
    }
}

class MainMethod{
    public static void main(String[] args) {
        A1 a2=new A1();
        a2.dance();
    }
}

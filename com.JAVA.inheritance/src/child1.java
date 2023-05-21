public class child1 extends Parent{
    double height;

    public child1() {
    }

    public child1(double height) {
        this.height = height;
    }

    //method overriding
    @Override
    public void canWork() {
        System.out.println("method in child class child1");
    }

    public void isChild() {
        System.out.println("method in child1 isChild()");
    }

}

public abstract class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

     abstract void eat();

    abstract void dance();

    public void drive(){
        System.out.println("I am driving Person");
    }
}

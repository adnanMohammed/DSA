public class PersonSubClass extends Person{
    public PersonSubClass(String name) {
        super(name);
    }

    @Override
    void eat() {
        System.out.println("I am eating");
    }

    @Override
    void dance() {
        System.out.println("I am dancing");
    }
}

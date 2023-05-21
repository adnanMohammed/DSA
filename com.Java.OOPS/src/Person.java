public class Person extends Human{

    String Name;
    int age;
    String education;
    int Salary;
    String address;

    public Person() {
    }

    public Person(String name) {
        Name = name;

    }
    public Person(String name, int age, String education, int salary, String address) {
        Name = name;
        this.age = age;
        this.education = education;
        Salary = salary;
        this.address = address;
    }

    void dance(String danceStyle) {
        System.out.println(this.Name + " is dancing" + danceStyle);
    }

    void sing(String singStyle) {
        System.out.println(this.Name + " is singing" + singStyle);
    }

    void drive(String vehicle) {
        System.out.println(this.Name + " is driving" + vehicle);
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

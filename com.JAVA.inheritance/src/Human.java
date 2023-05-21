public class Human {

    String name;
    int age;
    String address;

    public Human() {

    }

    public Human(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public boolean canWork(String gender) {
        if (gender.equalsIgnoreCase("male"))
            return true;
        else
            return false;

    }
}

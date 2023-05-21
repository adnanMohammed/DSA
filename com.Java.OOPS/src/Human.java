public class Human {
    String name;
    int age;
    String address;
    String AadharNumber;
    static String country="India";

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", AadharNumber='" + AadharNumber + '\'' +
                '}';
    }

    public Human(String name, int age, String address, String aadharNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        AadharNumber = aadharNumber;
    }

    public Human() {
    }

    public void canEat(String name){
        System.out.println("I am eating ="+name);
    }

    public static void wakeup(){
        System.out.println("i woke up");
    }

    public void canDance(String danceStyle){
        System.out.println("i am dancing ="+danceStyle);

    }
}

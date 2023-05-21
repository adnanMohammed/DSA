public class Parent {
    private String name;
    private int age;
    double salary;
    String address;
    int pincode;

    public Parent(String name,int age) {
        this.name=name;
        this.age=age;
    }

     void eat(){
         System.out.println("I am eating");
    }

    static void dance(){
        System.out.println("I am dancing");
    }

    public Parent() {
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class HumanstaticExample {
    int name;
    static int age;
    String gender;
    static String country="india";

    static{
        age+=10;
        //gender="male";//instance variables cannot be available in static code blocks
    }
    public static void eat(String dish){
        //dance();// cant put non static methods in static method;
        System.out.println("I am eating ="+dish);
    }

    public void dance(String name){
        eat("rice");
        System.out.println(name +" is dancing");
    }


    public static void main(String[] args) {
        HumanstaticExample ex=new HumanstaticExample();
        ex.dance("Afnan");
        HumanstaticExample ex1=new HumanstaticExample();
        HumanstaticExample ex2=new HumanstaticExample();

    }
}

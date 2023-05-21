public class Student {

    String name;
    int age;
    String rollNo;
    float Marks;
    double salary;

    public Student(String name, int age, String rollNo, float marks, double salary) {

       this.name = name;
        age = age;
        rollNo = rollNo;
        Marks = marks;
        salary = salary;
    }

    public Student() {
       // this("adnan",10,"45",45f,45.0);
    }

    public static void canEat(String dish){
        System.out.println("I am eating "+dish);
    }


    public static void canEat(String dish,String action){
        System.out.println("I am eating "+dish+" while "+action);
    }

    public static void main(String[] args) {
       Student student1=new Student("adnan",27,"1",1.1f,12.2);

        //System.out.println(student1.name);
        Student s2=new Student();
        s2.name="faisalMohammed";
        Student s3=s2;
        if(student1==s3)
            System.out.println("true");
        else System.out.println("false");

        System.out.println("name="+s3.name);

    }


}



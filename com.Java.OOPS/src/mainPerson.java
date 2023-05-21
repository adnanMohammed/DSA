import jdk.swing.interop.SwingInterOpUtils;

public class mainPerson {
    public static void main(String[] args) {
        Person p=new Person("adnan");
        if (p instanceof Human){
            System.out.println("true");
        }



        p.hashCode();
        p.toString();
        if(p.Name.equals("adnan")){
            System.out.println("its adnan");
        }
    }
}

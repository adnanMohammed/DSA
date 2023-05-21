import java.util.Arrays;
import java.util.Collections;

public class empMain {
    public static void main(String[] args) {
        int[] arr=new int[4];
        arr[0]=3;arr[1]=1;arr[2]=9;arr[3]=6;
        Arrays.sort(arr);
        String[] s1=new String[3];
        s1[0]="zai";s1[1]="pai";s1[2]="and";
        Arrays.sort(s1);
        Employee e1 = new Employee(8, "mike", 25, 10000);
        Employee e2 = new Employee(5, "mike12", 29, 19040);
        Employee e3 = new Employee(3, "mike43", 35, 43000);
        Employee e4 = new Employee(1, "mike22", 55, 15000);
        Employee e5 = new Employee(9, "mike43", 15, 3400);

        Employee[] err1 = new Employee[5];
        err1[0] = e1;
        err1[1] = e2;
        err1[2] = e3;
        err1[3] = e4;
        err1[4] = e5;

        Arrays.sort(err1);
        System.out.println("Employee sorted list="+Arrays.toString(err1));

      // System.out.println(Employee.EmployeeSalaryComparator.compare(e1,e2));
        System.out.println();
        Arrays.sort(err1,Employee.EmployeeSalaryComparator);
        System.out.println("Employee sorted list="+Arrays.toString(err1));

        System.out.println();
        Arrays.sort(err1,Employee.EmployeeageComparator);
        System.out.println("Employee sorted list="+Arrays.toString(err1));


    }
}

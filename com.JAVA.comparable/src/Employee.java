import java.util.Comparator;

public class Employee implements Comparable<Employee>{
    private int empId;
    private String name;
    private int age;
    private long salary;

    public Employee(int empId, String name, int age, long salary) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    @Override
    public int compareTo(Employee o) {
        System.out.println("In comparable method");
        return this.getEmpId()-o.getEmpId();
    }



    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public static Comparator<Employee> EmployeeSalaryComparator=new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int)(o1.getSalary()-o2.getSalary());
        }
    };


    public static Comparator<Employee> EmployeeageComparator=new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.getAge()-o1.getAge();
        }
    };
}

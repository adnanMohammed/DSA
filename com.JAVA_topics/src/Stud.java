import java.util.Objects;

public class Stud implements Comparable<Stud> {
	private String name;
	private int age;
	private String dept;
	private String gender;

	public Stud() {
		// TODO Auto-generated constructor stub
	}

	public Stud(String name, int age, String dept, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.gender = gender;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, dept, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stud other = (Stud) obj;
		return age == other.age && Objects.equals(dept, other.dept) && Objects.equals(gender, other.gender)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Stud [name=" + name + ", age=" + age + ", dept=" + dept + ", gender=" + gender + "]";
	}

	@Override
	public int compareTo(Stud o) {
		// TODO Auto-generated method stub
		return this.getAge() - o.getAge();
	}

}

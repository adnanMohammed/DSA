import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stud s1 = new Stud("andn", 19, "EC", "male");
		Stud s2 = new Stud("faisal", 9, "CS", "male");
		Stud s3 = new Stud("nasir", 29, "CV", "male");
		Stud s4 = new Stud("nusr", 91, "MC", "female");
		Stud s5 = new Stud("an", 22, "EE", "male");
		Stud s6 = new Stud("andn", 20, "EC", "male");
		Stud[] s = { s1, s2, s3, s4, s5, s6 };
		List<Stud> col = new ArrayList<>();
		col.add(s1);
		col.add(s2);
		col.add(s3);
		col.add(s4);
		col.add(s5);
		Collections.sort(col);
		System.out.println(col);
		Comparator<Stud> sortByName = (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName());
		Comparator<Stud> sortByAge = (o1, o2) -> o1.getAge() - o2.getAge();
		Comparator<Stud> sortByDept = (o1, o2) -> o1.getDept().compareToIgnoreCase(o2.getDept());
		Comparator<Stud> sortByGender = (o1, o2) -> o1.getGender().compareToIgnoreCase(o2.getGender());
		Arrays.sort(s, sortByAge);
	}

}

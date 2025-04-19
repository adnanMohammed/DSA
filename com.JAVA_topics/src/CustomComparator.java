import java.util.Comparator;

public class CustomComparator implements Comparator<Stud>{

	@Override
	public int compare(Stud o1, Stud o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}

import java.util.Comparator;

public class CmpByAddress implements Comparator<Person>{
	public int compare(Person p1, Person p2) {
		int retVal = p1.getAddress().compareTo(p2.getAddress());
		return retVal;
	}
}

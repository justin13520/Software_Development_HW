import java.util.Comparator;

public class PhotoRatingComparator implements Comparator<Photo>{

	@Override
	public int compare(Photo p1, Photo p2) {
		int retVal = -(p1.getRating()-p2.getRating());
		if(retVal != 0) {
			return retVal;
		}
		retVal = p1.getCaption().compareTo(p2.getCaption());
		if(retVal != 0) {
			return retVal;
		}
		return 0;
	}
	
}

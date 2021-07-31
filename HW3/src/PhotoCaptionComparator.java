import java.util.Comparator;

public class PhotoCaptionComparator implements Comparator<Photo>{

	@Override
	public int compare(Photo p1, Photo p2) {
		int retVal = p1.getCaption().compareTo(p2.getCaption());
		if(retVal != 0) {
			return retVal;
		}
		retVal = -(p1.getRating()-p2.getRating());
		if(retVal != 0) {
			return retVal;
		}
		return 0;
	}
	public static void main(String[] args) {
		PhotoCaptionComparator cc = new PhotoCaptionComparator();
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		Photo d = new Photo("Watermelon","They're green","2003-01-01",4);
		System.out.println(cc.compare(b, d));
	}
}

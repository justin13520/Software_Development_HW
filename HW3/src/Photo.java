

public class Photo implements Comparable<Photo>{
	private String caption;
	private String filename;
	private int rating;
	private final String dateTaken;
	public static void main(String[] args) {
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		Photo c = new Photo("Tomatoes", "They're red","2002-01-01",1);
		Photo d = new Photo("Watermelon","They're green","2003-01-01",4);
		Photo e = new Photo("Hearthstone","Pay to win game","2014-05-01",5);
		System.out.println(a.getCaption());
		System.out.println(b.getCaption());
		System.out.println(c.getCaption());
		System.out.println(d.getCaption());
		System.out.println(e.getCaption());
		System.out.println(a instanceof Object);
	}
	
	public Photo(String f, String c) {
		this.dateTaken = "1901-01-01";
		this.filename = f;
		this.caption = c;
		this.rating = 1;
	}
	
	public Photo(String f, String c, String dateTaken, int r) {
		this.caption = c;
		this.filename = f;
		if(DateLibrary.isValidDate(dateTaken)) {
			this.dateTaken = dateTaken;
		}
		else {
			this.dateTaken = "1901-01-01";
		}
		if(r < 1 || r > 5) {
			this.rating = 1;
		}
		else {
			this.rating = r;
		}
	}
	
	public String getCaption() {
		return caption;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public int getRating() {
		return rating;
	}
	
	public String getDateTaken() {
		return dateTaken;
	}
	
	public boolean setRating(int newRating) {
		if(newRating > 0 && newRating < 6 && newRating != this.rating) {
			this.rating = newRating;
			return true;
		}
		return false;
	}
	
	public boolean equals(Object o) {
		if(o == null) {//null check
			return false;
		}
		if(o instanceof Photo) {
			Photo a = (Photo)o;//type cast
			return (this.filename.equals(a.getFilename()) && this.caption.contentEquals(a.getCaption()));
		}
		return false;
	}
	
	public String toString() {
		return this.filename + ", which has the caption \"" + this.caption +"\"";
	}
	@Override
	
	public int hashCode() {
		return this.filename.hashCode();
	}
	
	@Override
	public int compareTo(Photo p) {
		int retVal = this.dateTaken.compareTo(p.dateTaken);
		if(retVal != 0) {
			return retVal;
		}
		retVal = this.caption.compareTo(p.caption);
		if(retVal != 0) {
			return retVal;
		}
		return 0;
	}
}

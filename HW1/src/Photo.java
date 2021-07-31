
public class Photo {
	private String caption;
	private String filename;
	private int rating;
	public static void main(String[] args) {
		Photo a = new Photo("Apples","They're red");
		Photo b = new Photo("Apples","They're red");
		Photo c = new Photo("Tomatoes", "They're red");
		Photo d = new Photo("Apples","They're red", 0);
		System.out.println(a.setRating(3));//should return true
		System.out.println(a.equals(b));//should return true
		System.out.println(a.setRating(6));//should return false
		System.out.println(a.equals(c));//should return false
		System.out.println(d.getRating());
		System.out.println(a.equals(d));
		System.out.println(a.getCaption());
	}
	public Photo(String f, String c) {
		filename = f;
		caption = c;
		rating = 1;
	}
	public Photo(String f, String c, int r) {
		filename = f;
		caption = c;
		if(r>0 && r<6) {
			rating = r;
		}
		else {
			rating = 1;
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
	public boolean setRating(int newRating) {
		if(newRating > 0 && newRating < 6 && newRating != this.rating) {
			this.rating = newRating;
			return true;
		}
		return false;
	}
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(o instanceof Photo) {
			Photo a = (Photo)o;
			return (this.filename.equals(a.getFilename()) && this.caption.contentEquals(a.getCaption()));
		}
		return false;
	}
	public String toString() {
		return this.filename + ", which has the caption \"" + this.caption +"\"";
	}
}

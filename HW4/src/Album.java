import java.util.ArrayList;

public class Album extends PhotoContainer{

	public Album(String n) {
		super(n);
		name = n;
		photos = new ArrayList<Photo>();
	}
	
	public static void main(String[] args) {
		Library l = new Library("UVA",1);
		Album a = new Album("UVA1");
		Photo e = new Photo("Hearthstone","Pay to win game","2014-05-01",5);
		l.addPhoto(e);
		a.addPhoto(e);
		System.out.println(l);
		System.out.println(a);
	}
}

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
	Library l;
	
	@Before
	public void setup() {
		l = new Library("CVHS", 0);
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		Photo c = new Photo("Tomatoes", "They're red","2002-01-01",1);
		Photo d = new Photo("Watermelon","They're green","2003-01-01",4);
		Photo e = new Photo("Hearthstone","Pay to win game","2014-05-01",5);
		l.addPhoto(a);
		l.addPhoto(b);
		l.addPhoto(c);
		l.addPhoto(d);
		l.addPhoto(e);
	}
	
	@Test(timeout=100)
	public void testGetPhotos() {
		ArrayList<Photo> p = new ArrayList<Photo>();
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		Photo c = new Photo("Tomatoes", "They're red","2002-01-01",1);
		Photo d = new Photo("Watermelon","They're green","2003-01-01",4);
		Photo e = new Photo("Hearthstone","Pay to win game","2014-05-01",5);
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		p.add(e);
		boolean b1 = true;
		for(int i = 0; i < p.size(); i++) {
			if(!(p.get(i).equals(l.getPhotos().get(i)))) {
				b1 = false;
				i = p.size();
			}
		}
		assertTrue(b1);
	}
	
	@Test(timeout=100)
	public void testGetPhotosInMonth() {
		ArrayList<Photo> p = new ArrayList<Photo>();
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		p.add(a);
		p.add(b);
		assertTrue(p.equals(l.getPhotosInMonth(8, 2001)));
		}
	
	@Test(timeout=100)
	public void testGetPhotosBetween() {
		ArrayList<Photo> p =  new ArrayList<Photo>();
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		p.add(a);
		p.add(b);
		assertTrue(p.equals(l.getPhotosBetween("2001-08-01", "2001-08-31")));
	}
	
	@Test(timeout=100)
	public void testDeletePhoto() {
		ArrayList<Photo> p = new ArrayList<Photo>();
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		Photo c = new Photo("Tomatoes", "They're red","2002-01-01",1);
		Photo d = new Photo("Watermelon","They're green","2003-01-01",4);
		Photo e = new Photo("Hearthstone","Pay to win game","2014-05-01",5);
		Photo f = new Photo("Tanjiro", "Best boy", "2019-12-23",5);
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		assertTrue(l.removePhoto(e) == true);
		assertFalse(l.removePhoto(f));
		assertTrue(p.equals(l.getPhotos()));
	}
	
	@Test(timeout=100)
	public void testSimilarity() {
		Library l2 = new Library("FHS",2);
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		Photo c = new Photo("Tomatoes", "They're red","2002-01-01",1);
		Photo d = new Photo("Watermelon","They're green","2003-01-01",4);
		Photo e = new Photo("Hearthstone","Pay to win game","2014-05-01",5);
		Library l3 = new Library("Clark", 5);
		l2.addPhoto(a);
		l2.addPhoto(b);
		l2.addPhoto(c);
		l2.addPhoto(d);
		l2.addPhoto(e);
		assertEquals(1.0, Library.similarity(l, l2), .01);
		assertEquals(0.0, Library.similarity(l2, l3), .01);
	}

}

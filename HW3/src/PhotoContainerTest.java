import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhotoContainerTest {

	Library l;
	PhotoCaptionComparator cc;
	PhotoRatingComparator rc;
	
	@Before
	public void setup() {
		l = new Library("UVA",1);
		cc = new PhotoCaptionComparator();
		rc = new PhotoRatingComparator();
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
	
	@Test(timeout = 100)
	public void testRemovePhoto() {
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo f = new Photo("Parth", "Next to Justin", "2020-03-02",5);
		assertTrue(l.removePhoto(a));
		assertFalse(l.removePhoto(f));
	}
	
	@Test(timeout = 100)
	public void testCompareTo() {
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		assertTrue(a.compareTo(b) > 0);
	}
	
	@Test(timeout = 100)
	public void testCompareInPhotoCaptionComparator() {
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		Photo d = new Photo("Watermelon","They're green","2003-01-01",4);
		assertEquals(0,cc.compare(a,b));
		assertTrue(0 < cc.compare(b, d));
	}
	
	@Test(timeout = 100)
	public void testCompareInPhotoRatingComparator() {
		Photo a = new Photo("Apples","They're red","2001-08-08",5);
		Photo b = new Photo("Cherries","They're red","2001-08-07",5);
		Photo c = new Photo("Tomatoes", "They're red","2002-01-01",1);
		Photo d = new Photo("Watermelon","They're green","2003-01-01",4);
		Photo e = new Photo("Hearthstone","Pay to win game","2014-05-01",5);
		assertTrue(0 < rc.compare(c, b));
	}

}

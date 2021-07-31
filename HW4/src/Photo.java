import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

public class Photo implements Comparable<Photo>{
	private String caption;
	private String filename;
	private int rating;
	protected BufferedImage imageData;
	private final String dateTaken;
	static String imageDirectory = "images/";
	
	public static void main(String[] args) {
		Photo a = new Photo(imageDirectory+"IMG_1212.JPG","That's a stingray","2019-11-17",4);
		Photo b = new Photo(imageDirectory+"IMG_1220.JPG", "Turtle", "2019-11-17", 3);
		Photo c = new Photo(imageDirectory+"IMG_1228.JPG", "Coral", "2019-11-17", 5);
		Photo d = new Photo(imageDirectory+"IMG_1242.JPG", "Lighting of the Lawn", "2019-12-5", 2);
		Photo e = new Photo(imageDirectory+"IMG_1341.JPG", "Volleyball court empty", "2020-02-14", 1);
		
		ArrayList<Photo> p = new ArrayList<Photo>();
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		p.add(e);
		Collections.sort(p);
		System.out.println(p);
		System.out.println(d.compareTo(a));
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
		if(loadImageData(f)) {
			try {
				this.imageData = ImageIO.read(new File(f));
			} catch (IOException e) {
				this.imageData = null;
			} 
		}
	}
	
	public String getCaption() {
		return caption;
	}
	
	public String getFilename() {
		return this.filename;
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
	
	public BufferedImage getImageData() {
		return imageData;
	}

	public void setImageData(BufferedImage imageData) {
		this.imageData = imageData;
	}

	public boolean loadImageData(String filename) {
		BufferedImage img;
		try{
			img = ImageIO.read(new File(filename));
		}
		catch(IOException e){
			return false;
		}
		imageData = img;
		return true;
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

import java.util.ArrayList;
import java.util.HashSet;

public class Library {
	private String name;
	private final int id;
	private ArrayList<Photo> photos;
	private HashSet<Album> albums;

	public static void main(String[] args) {
		//
	}

	public Library(String n, int i) {
		name = n;
		id = i;
		photos = new ArrayList<Photo>();
		albums = new HashSet<Album>();
	}

	public HashSet<Album> getAlbums() {
		return albums;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Photo> getPhotos() {
		return photos;
	}

	public int getId() {
		return id;
	}

	public boolean addPhoto(Photo p) {
		if (!hasPhoto(p)) {// if the photo is already there, then is wont add it, making it false
			this.photos.add(p);
			return true;
		}
		return false;
	}

	public boolean hasPhoto(Photo p) {
		if (this.photos.size() == 0) {// checks if there is a photo. no photos obviously mean has none
			return false;
		}
		for (int k = 0; k < this.photos.size(); k++) {// checks every photo in library with parameter
			if (photos.get(k).equals(p)) {
				return true;
			}
		}
		return false;
	}

	public boolean deletePhoto(Photo p) {
		if (hasPhoto(p)) {// makes sure there is a photo in the first place to delete
			this.photos.remove(p);
			for(Album p1 : this.albums) {
				p1.removePhoto(p);
			}
			return true;
		}
		return false;
	}

	public int numPhotos() {
		if (this.photos.size() > 0) {// makes sure there is more than one
			return this.photos.size();
		}
		return 0;
	}

	public boolean equals(Object o) {
		if (o == null) {// checks for null
			return false;
		}
		if (o instanceof Library) {// checks if object is the same type
			Library a = (Library) o;
			if (a.getId() == this.getId()) {// sees if it is the same ID
				return true;
			}
			return false;
		} else {// not same type
			return false;
		}
	}

	public String toString() {
		return "The Library, " + name + ", has the id: " + this.id +". "+this.albums.toString()+". "+ "The photos it has are "+ this.photos.toString()+".";
	}

	public static ArrayList<Photo> commonPhotos(Library a, Library b) {
		ArrayList<Photo> c = new ArrayList<Photo>();
		if (a.photos.size() == 0 || b.photos.size() == 0) {// if either is empty, no common
			return c;// returns default c because no common, which is empty
		}
		if (a.photos.size() >= b.photos.size()) {// checks which is smaller
			for (int q = 0; q < a.photos.size(); q++) {
				for (int w = 0; w < b.photos.size(); w++) {
					if (a.photos.get(q).equals(b.photos.get(w))) {
						c.add(a.photos.get(q));
					}
				}
			}
		}
		if (a.photos.size() < b.photos.size()) {// checks which is smaller
			for (int e = 0; e < b.photos.size(); e++) {
				for (int s = 0; s < a.photos.size(); s++) {
					if (b.photos.get(e).equals(a.photos.get(s))) {
						c.add(b.photos.get(e));
					}
				}
			}
		}
		return c;
	}

	public static double similarity(Library a, Library b) {
		double sim = 0;// local used to show ratio
		// if there is no common photos, then obviously no similarities
		if (a.numPhotos() == 0 || b.numPhotos() == 0) {
			return 0.0;
		}
		ArrayList<Photo> c = commonPhotos(a, b);
		// have to check which one is the smaller to divide by the correct size
		// if they're the same size, it doesn't matter which is used to divide
		if (a.photos.size() <= b.photos.size()) {
			sim = (double) c.size() / a.photos.size();
			return sim;
		}
		if (a.photos.size() > b.photos.size()) {
			sim = (double) c.size() / b.photos.size();
			return sim;
		}
		return sim;
	}

	public ArrayList<Photo> getPhotos(int rating) {
		ArrayList<Photo> lst = new ArrayList<Photo>();//arrraylist to store the photos with the rating in parameter
		for (int i = 0; i < this.photos.size(); i++) {
			if (this.photos.get(i).getRating() >= rating) {
				lst.add(this.photos.get(i));
			}
		}
		return lst;
	}

	public ArrayList<Photo> getPhotosInYear(int year) {
		ArrayList<Photo> lst2 = new ArrayList<Photo>();
		if(year < 0 || year > 9999) {//checks if year is valid
			return null;
		}
		for (int k = 0; k < this.photos.size(); k++) {
			if (DateLibrary.getYear(this.photos.get(k).getDateTaken()) == year) {//compares year, if equal, then add
				lst2.add(this.photos.get(k));
			}
		}
		return lst2;
	}

	public ArrayList<Photo> getPhotosInMonth(int month, int year) {
		ArrayList<Photo> lst3 = new ArrayList<Photo>();
		if (month < 0 || month > 12 || Integer.toString(year).length() != 4) {// checks if the month and year are valid
			return null;
		}
		for (int j = 0; j < this.photos.size(); j++) {
			if (DateLibrary.getMonth(this.photos.get(j).getDateTaken()) == month //checks month if same 
					&& DateLibrary.getYear(this.photos.get(j).getDateTaken()) == year) {//checks year if same
				lst3.add(this.photos.get(j));
			}
		}
		return lst3;
	}

	public ArrayList<Photo> getPhotosBetween(String beginDate, String endDate) {
		ArrayList<Photo> lst4 = new ArrayList<Photo>();
		if (DateLibrary.isValidDate(beginDate) && DateLibrary.isValidDate(endDate)
				&& DateLibrary.compare(beginDate, endDate) < 0) {//checks if the dates are valid AND if the beginDate is before endDate
			for (Photo p : this.photos) {
				if (DateLibrary.compare(beginDate, p.getDateTaken()) <= 0 //should be negative or equal to signify same day or after begin
						&& DateLibrary.compare(endDate, p.getDateTaken()) >= 0) {//should be positive or equal to signify same day or before end date
					lst4.add(p);
				}
			}
			return lst4;
		}
		return null;
	}

	public boolean createAlbum(String albumName) {
		Album a = new Album(albumName);
		return this.albums.add(a);//creates a new album and adds it to the hashset of albums, which if already there, will return false
	}

	public boolean removeAlbum(String albumName) {
		for (Album aName : this.albums) {//searches hashset to see if the album is there
			if (aName.getName().equals(albumName)) {
				return this.albums.remove(aName);
			}
		}
		return false;
	}

	public boolean addPhotoToAlbum(Photo p, String albumName) {
		if(this.photos.contains(p)) {//checks if it is in library first
			for (Album a : this.albums) {
				if (a.getName().equals(albumName)) {//if same name, adds it
					return a.addPhoto(p);
				}
			}
			return false;
		}
		return false;
	}

	public boolean removePhotoFromAlbum(Photo p, String albumName) {
		for (Album a : this.albums) {//searches for albumname
			if (a.getName().equals(albumName)) {//if equals, removes it, if not there hashset remove returns false
				return a.removePhoto(p);
			}
		}
		return false;
	}

	public Album getAlbumByName(String albumName) {
		for (Album a : this.albums) {
			if (a.getName().equals(albumName)) {//compares the name of the albumname with the ones in the library's current album hashset
				return a;
			}
		}
		return null;
	}

	public boolean erasePhoto(Photo p) {
		this.photos.remove(p);
		for (Album a : this.albums) {
			if (a.hasPhoto(p)) {
				a.removePhoto(p);
			}
		}
		return false;
	}

}

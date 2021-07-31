import java.util.ArrayList;
import java.util.HashSet;

public class Library extends PhotoContainer{
	private final int id;
	private HashSet<Album> albums;

	public static void main(String[] args) {
		Library l = new Library("UVA",1);
		Photo e = new Photo("Hearthstone","Pay to win game","2014-05-01",5);
		l.addPhoto(e);
		System.out.println(l);
	}

	public Library(String n, int i) {
		super(n);
		id = i;
		photos = new ArrayList<Photo>();
		albums = new HashSet<Album>();
	}

	public HashSet<Album> getAlbums() {
		return albums;
	}

	public int getId() {
		return id;
	}

	public boolean removePhoto(Photo p) {
		if (hasPhoto(p)) {// makes sure there is a photo in the first place to delete
			this.photos.remove(p);
			for(Album p1 : this.albums) {
				p1.removePhoto(p);
			}
			return true;
		}
		return false;
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

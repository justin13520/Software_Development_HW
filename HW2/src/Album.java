import java.util.HashSet;

public class Album {
	private String name;
	private HashSet<Photo> photos;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Album(String n) {
		name = n;
		photos = new HashSet<Photo>();
	}
	
	public HashSet<Photo> getPhotos() {
		return photos;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean addPhoto(Photo p) {
		if(p == null) {//null check
			return false;
		}
		return this.photos.add(p);//returns this because for sets, adding returns a boolean if successful and false if not
	}
	
	public boolean hasPhoto(Photo p) {
		for(Photo p1 : this.photos) {
			if(p1.equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean removePhoto(Photo p) {
		return this.photos.remove(p);//returns this because for sets, adding returns a boolean if successful and false if not
	}
	
	public int numPhotos() {
		return this.photos.size();
	}
	
	public boolean equals(Object o) {
		if(o == null) {//null check
			return false;
		}
		if(o instanceof Album) {//type check
			if(this.name.equals(((Album) o).getName())) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String n = this.name + ": ";
		for(Photo p : this.photos) {
			n += p.toString();
		}
		return ("The photos in album are" + n);
	}
	
	public int hashCode() {
		return this.name.hashCode();
	}

}

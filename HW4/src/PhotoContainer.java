import java.util.ArrayList;

public abstract class PhotoContainer {
	
	protected String name;
	protected ArrayList<Photo> photos;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public PhotoContainer(String n) {
		this.name = n;
		this.photos = new ArrayList<Photo>();
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

	
}

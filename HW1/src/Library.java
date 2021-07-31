import java.util.ArrayList;
public class Library {
	private String name;
	private final int id;
	private ArrayList<Photo> photos;
	public static void main(String[] args) {
		//A bunch of photos, some with same captions
		Photo a = new Photo("Apples","They're red");
		Photo b = new Photo("Cherries","They're red");
		Photo c = new Photo("Tomatoes", "They're red");
		Photo d = new Photo("Watermelon","They're green", 5);
		Photo e = new Photo("Hearthstone","Pay to win game");
		//new arraylist
		ArrayList<Photo> p = new ArrayList<Photo>();
		Library l = new Library("CVHS",1);
		Library l2 = new Library("FHS",1);
		Library l3 = new Library("UVA", 2);
		//checks if addPhoto works
		System.out.println(l.addPhoto(a));//true
		System.out.println(l.addPhoto(a));//false
		//checks if has photo works
		System.out.println(l.hasPhoto(a));//true
		System.out.println(l.hasPhoto(b));//false
		//checks if it does delete photo
		System.out.println(l.deletePhoto(a));//true
		System.out.println(l.deletePhoto(a));//false
		
		System.out.println(l.numPhotos());//0
		l.photos.add(a);
		l.photos.add(b);
		l.photos.add(c);
		l.photos.add(d);
		System.out.println(l.numPhotos());//4
		
		System.out.println(l.equals(l2));//true
		System.out.println(l.equals(l3));//false
		
		System.out.println(l.toString());
		System.out.println(l2.toString());
		
		l2.photos.add(a);
		l2.photos.add(c);
		l3.photos.add(a);
		l3.photos.add(b);
		l3.photos.add(c);
		l3.photos.add(e);
		System.out.println(commonPhotos(l,l2));
		System.out.println(commonPhotos(l,l3));
		
		System.out.println(similarity(l,l2));//1.0
		System.out.println(similarity(l,l3));//.75
		
		
	}
	public Library(String n, int i) {
		name = n;
		id = i;
		photos = new ArrayList<Photo>();
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
		if(!hasPhoto(p)) {//if the photo is already there, then is wont add it, making it false
			this.photos.add(p);
			return true;
		}
		return false;
	}
	public boolean hasPhoto(Photo p) {
		if(this.photos.size() == 0) {//checks if there is a photo. no photos obviously mean has none
			return false;
		}
		for(int k = 0; k < this.photos.size(); k++) {//checks every photo in library with parameter
			if(photos.get(k).equals(p)) {
				return true;
			}	
		}
		return false;
	}
	public boolean deletePhoto(Photo p) {
		if(hasPhoto(p)) {//makes sure there is a photo in the first place to delete
			this.photos.remove(p);
			return true;
		}
		return false;
	}
	public int numPhotos() {
		if(this.photos.size() > 0) {//makes sure there is more than one
			return this.photos.size();
		}
		return 0;
	}
	public boolean equals(Object o) {
		if(o == null) {//checks for null
			return false;
		}
		if(o instanceof Library) {//checks if object is the same type 
			Library a = (Library)o;
			if(a.getId() == this.getId()) {//sees if it is the same ID
				return true;
			}
			return false;
		}
		else{//not same type
			return false;
		}
	}
	public String toString() {
		String photoNames = "";
		if(this.photos.size() > 0) {
			for(int m = 0; m < this.photos.size(); m++) {
				if(m == this.photos.size()-1) {
					photoNames += this.photos.get(m)+".";
				}
				else{
					photoNames += this.photos.get(m) + ", ";
				}
			}
			return "The Library, " + name + ", has the id: " + id +". It has the photos: " + photoNames;
		}
		return "The Library, " + name + ", has the id: " + id + ". It currently has 0 photos in it.";
	}
	public static ArrayList<Photo> commonPhotos(Library a, Library b){
		ArrayList<Photo> c = new ArrayList<Photo>();
		if(a.photos.size() == 0 || b.photos.size() == 0) {//if either is empty, no common
			return c;//returns default c because no common, which is empty
		}
		if(a.photos.size() >= b.photos.size()) {//checks which is smaller
			for(int q = 0; q < a.photos.size(); q++) {
				for(int w = 0; w < b.photos.size(); w++) {
					if(a.photos.get(q).equals(b.photos.get(w))){
						c.add(a.photos.get(q));
						}
					}
				}
			}
		if(a.photos.size() < b.photos.size()) {//checks which is smaller
			for(int e = 0; e < b.photos.size(); e++) {
				for(int s = 0; s < a.photos.size(); s++) {
					if(b.photos.get(e).equals(a.photos.get(s))){
						c.add(b.photos.get(e));
						}
					}
				}
			}
		return c;
		}
	public static double  similarity(Library a, Library b) {
		double sim = 0;//local used to show ratio
		//if there is no common photos, then obviously no similarities
		if(a.numPhotos()==0 || b.numPhotos()==0) {
			return 0.0;
		}
		ArrayList<Photo> c = commonPhotos(a,b);
		//have to check which one is the smaller to divide by the correct size
		//if they're the same size, it doesn't matter which is used to divide
		if(a.photos.size() <= b.photos.size()) {
			sim =  (double)c.size()/a.photos.size();
			return sim;
		}
		if(a.photos.size() > b.photos.size()) {
			sim =  (double)c.size()/b.photos.size();
			return sim;
		}
		return sim;
	}
}

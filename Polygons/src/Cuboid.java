/**
 * 
 * @author CS 2110 faculty
 * Cuboid class
 * a cuboid is a 3d rectangle - 6 rectangles joined at right angles
 *
 */
public class Cuboid implements Solids {

	private double length, width, height;
	private String color, name;
	/** constructor */
	public Cuboid(double length, double width, double height, String c, String n){
		this.length = length;
		this.width = width;
		this.height = height;
		this.color = c;
		this.name = "Cuboid";
	}
	
	//Volume = length*width*height
	public double getVolume(){
		return this.length*this.height*this.width;
	}
	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
	
}

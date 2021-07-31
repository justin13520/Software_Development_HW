/**
 * 
 * @author CS 2110 faculty
 * Sphere class
 * a Sphere is a 3d shape representing all points equidistant from a center point
 *
 */
public class Sphere implements Solids {
	
	private double radius;
	private String color, name;
	/** constructor */
	public Sphere(double radius, String c, String n){
		this.radius = radius;
		this.color = c;
		this.name = "Sphere";
	}
	
	//Volume = 4/3*pi*r^3
	public double getVolume(){
		return 4/3*Math.PI*Math.pow(this.radius, 3);
	}
	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
}

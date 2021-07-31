/**
 * 
 * @author CS 2110 faculty
 * Pyramid class
 * a pyramid is a 3d shape made from 1 rectangle and 4 triangles - like an octahedron bisected through the square
 *
 */
public class Pyramid implements Solids {

	private double length, width, height;
	private String color, name;

	/** constructor */
	public Pyramid(double length, double width, double height, String c, String n) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.color = c;
		this.name = "Pyramid";
	}
	
	//Volume = length*width*height/3
	public double getVolume(){
		return this.length*this.height*this.width/3;
	}
	public String getName() {
		return "Pyramid";
	}
	public String getColor() {
		return this.color;
	}
}

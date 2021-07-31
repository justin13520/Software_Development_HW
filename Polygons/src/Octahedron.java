/**
 * 
 * @author CS 2110 faculty
 * Octahedron class
 * an Octahedron is a 3d shape made from only 8 equilateral triangles 
 *
 */
public class Octahedron implements Solids{
	
	private double edge;
	private String color, name;
	/** constructor */
	public Octahedron(double edge, String c, String n){
		this.edge = edge;
		this.color = c;
		this.name = "Octaherdron";
	}
	
	//Volume sqrt(2)/3 times edge^3
	public double getVolume(){
		return (Math.sqrt(2)/3)*(Math.pow(this.edge, 3));
	}
	public String getName() {
		return "Octahedron";
	}
	public String getColor() {
		return this.color;
	}
}

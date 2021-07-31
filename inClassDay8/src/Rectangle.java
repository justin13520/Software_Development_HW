import java.awt.geom.Area;

public class Rectangle {
	
	private double length, width;
	//default constructor
	public Rectangle() {
		length = 1;
		width = 1;
	}
	
	public Rectangle(double l, double w) {
		this.length = l;
		this.width = w;
	}
	//Mutators
	public void setLength(double l) {
		length = l;
	}
	public void setWidth(double w) {
		width = w;
	}
	//Accessors
	public double getLength() {
		return this.length;
	}
	public double getWidth() {
		return this.width;
	}
	public String toString() {
		return "The length is "+this.length + ", and the width is " + this.width + ".";
	}
	public double area() {
		return this.getLength()*this.getWidth();
	}
	public static void main(String[] args) {
		Rectangle a = new Rectangle(5,5);
		Rectangle b = new Rectangle();
		System.out.println(a.getLength());
		System.out.println(a.toString());
		a.setLength(10);
		a.setWidth(10);
		System.out.println(a.toString());
		System.out.println(a.area());
		System.out.println(b.getLength());
	}

}

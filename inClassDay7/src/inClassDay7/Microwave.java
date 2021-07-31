package inClassDay7;

public class Microwave {
	//fields
	public double size;
	public boolean powered;
	public boolean open;
	public boolean inUse;
	//Constructor
	public Microwave(double s, boolean p, boolean o, boolean iu) {
		size = s;
		powered = p;
		open = o;
		inUse = iu;
	}
	//Methods/behavior
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public void cook(int seconds) {
		//cooks food for x seconds
	}
	public void defrost(int seconds) {
		//defrost food for x seconds
	}
	public boolean pops() {
		//pops popcorn
		return true;
	}
	public void turnOn() {
		powered = true;
	}
	public void turnOff() {
		powered = false;
	}
	public void open() {
		open = true;
	}
	public void close() {
		open = false;
	}
	public boolean isInUse() {
		return inUse;
	}
}

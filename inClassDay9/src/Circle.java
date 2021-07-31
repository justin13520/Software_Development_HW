
public class Circle {

	private Point p;
	private double radius;
	
	public Circle(Point c, double rad){
		p = c;
		radius = rad;
	}
	
	public Circle(){
		p = new Point(0,0);
		radius = 1;
	}
	
	
	
	public static void main(String[] args) {
	
		Point p = new Point(1,1);
		Circle c = new Circle(p, 3);
		System.out.println(c);
		
		String s = "3.1415";
		double pi = Double.parseDouble(s);
		System.out.println(pi * 5);
		
		Point p0 = p;
		Circle c0 = c;
		Circle c4 = c0;
		System.out.println(c.equals(c0));
		System.out.println(c == c0);
		System.out.println(3 == c.radius);
		System.out.println(p0.equals(c.p));
		
		Point p1 = new Point(2,2);
		Circle c1 = new Circle(p1,2);
		Point p2 = new Point(2,2);
		Circle c2 = new Circle(p2,2);
		System.out.println(c1.equals(c2));
		
		System.out.println(c.equals(c2));
		
		
	}
	public boolean equals(Object o) {
		if( o == null) {
			return false;
		}
		if(o instanceof Circle) {
			Circle a = (Circle)o;
			if(this.radius == a.radius && this.p.equals(a.p)) {
				return true;
			}
		}
		return false;
	}
	private Circle Circle(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(){
		return "<" + p + ", " + "radius: " + radius +">";
	}

}

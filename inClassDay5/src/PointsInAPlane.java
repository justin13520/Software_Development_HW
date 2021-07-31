
public class PointsInAPlane {

	public static void main(String[] args) {
		// you'll put your tests here
		double res = points(5.0,5.0);
		System.out.println(res);
		
		double res1 = points(-1,5);
		System.out.println(res1);
		
		double res2 = points(-6,-3);
		System.out.println(res2);
		
		double res3 = points(5,-3);
		System.out.println(res3);
		
		double res4 = points(5,6);
		System.out.println(res4);
		
	}
	public static double points(double x, double y) {
		if(x>=0 && y>=0) {
			return x/y;
		}
		else if(x<0 && y >= 0){
			return x-y;
		}
		else if(x<0 && y<0) {
			return x/y;
		}
		else {
			return x+y;
		}
	}
}
